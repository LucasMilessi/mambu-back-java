package com.mambu.bancomambu.service.passive.impl;

import com.mambu.bancomambu.model.account.BlockFundsDTO;
import com.mambu.bancomambu.model.account.RequestSeizeAccountDTO;
import com.mambu.bancomambu.model.account.ResponseSeizeAccountDTO;
import com.mambu.bancomambu.model.passiveAnnexe.BlockAndSeizeRequestDTO;
import com.mambu.bancomambu.service.passive.BlockFundsService;
import com.mambu.bancomambu.service.passive.BlockSeizureAccountService;
import com.mambu.bancomambu.service.passive.SeizureTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BlockSeizureAccountServiceImpl implements BlockSeizureAccountService {

    @Autowired
    private BlockFundsService blockFundsService;

    @Autowired
    private SeizureTransactionsService seizureTransactionsService;

    @Override
    public Mono<ResponseSeizeAccountDTO> blockAndSeizeAccount(String idAccount, BlockAndSeizeRequestDTO blockAndSeizeRequestDTO){

        var blockFundsDTO = BlockFundsDTO.builder()
                .amount(blockAndSeizeRequestDTO.getAmount())
                .externalReferenceId(blockAndSeizeRequestDTO.getExternalReferenceId())
                .notes(blockAndSeizeRequestDTO.getNotes())
                .build();

        return blockFundsService.blockAccount(idAccount, blockFundsDTO).flatMap( blockRes -> {

            var seizeAccountDTO = RequestSeizeAccountDTO.builder()
                    .amount(blockAndSeizeRequestDTO.getAmount())
                    .blockId(blockRes.getExternalReferenceId())
                    .externalId(blockAndSeizeRequestDTO.getExternalId())
                    .transactionChannelId(blockAndSeizeRequestDTO.getTransactionChannelId())
                    .notes(blockAndSeizeRequestDTO.getNotesSeize())
                    .build();

               return seizureTransactionsService.blockAccount(idAccount, seizeAccountDTO);
        });
    }
}
