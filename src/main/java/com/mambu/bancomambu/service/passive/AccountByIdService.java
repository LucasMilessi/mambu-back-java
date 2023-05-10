package com.mambu.bancomambu.service.passive;

import com.mambu.bancomambu.model.account.BlockConsultantDTO;
import reactor.core.publisher.Mono;

public interface AccountByIdService {
    Mono<BlockConsultantDTO> getAccountById(String idAccount, String detailsLevel);
}
