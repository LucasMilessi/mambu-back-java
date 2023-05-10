package com.mambu.bancomambu.service.passive;

import com.mambu.bancomambu.model.account.BlockFundsDTO;
import com.mambu.bancomambu.model.account.BlockFundsResponseDTO;
import reactor.core.publisher.Mono;

public interface BlockFundsService {
    Mono<BlockFundsResponseDTO> blockAccount(String id, BlockFundsDTO blockFundsDTO);
}
