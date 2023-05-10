package com.mambu.bancomambu.service.passive.impl;

import com.mambu.bancomambu.model.account.BlockAccountDTO;
import com.mambu.bancomambu.model.account.BlockConsultantDTO;
import com.mambu.bancomambu.model.passiveAnnexe.BlockSearchRequestDTO;
import com.mambu.bancomambu.service.passive.AccountByIdService;
import com.mambu.bancomambu.service.passive.BlockAccountService;
import com.mambu.bancomambu.service.passive.BlockAndConsultAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BlockAndConsultAccountServiceImpl implements BlockAndConsultAccountService {

    @Autowired
    private BlockAccountService blockAccountService;

    @Autowired
    private AccountByIdService accountByIdService;

    private final String DETAILSLEVEL = "BASIC";

    @Override
    public Mono<BlockConsultantDTO> blockAndConsultAccount(String idCuenta, BlockSearchRequestDTO blockSearchRequestDTO){

        var block = BlockAccountDTO.builder()
                .action(blockSearchRequestDTO.getAction())
                .notes(blockSearchRequestDTO.getNotes())
                .build();

        return blockAccountService.blockAccount(idCuenta, block).flatMap( resp ->
            accountByIdService.getAccountById(resp.getId(), DETAILSLEVEL)
        );

    }
}
