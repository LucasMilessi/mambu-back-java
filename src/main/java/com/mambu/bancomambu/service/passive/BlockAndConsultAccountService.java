package com.mambu.bancomambu.service.passive;

import com.mambu.bancomambu.model.account.BlockConsultantDTO;
import com.mambu.bancomambu.model.passiveAnnexe.BlockSearchRequestDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BlockAndConsultAccountService {
    Mono<BlockConsultantDTO> blockAndConsultAccount(String idCuenta, BlockSearchRequestDTO blockSearchRequestDTO);
}
