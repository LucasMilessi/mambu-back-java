package com.mambu.bancomambu.service.passive;

import com.mambu.bancomambu.model.account.BlockFundsResponseDTO;
import reactor.core.publisher.Flux;

public interface AllBlockByIdAccountService {
    Flux<BlockFundsResponseDTO> allBlockById(String id, String offset, String limit,
                                             String detailsLevel, String state);
}
