package com.mambu.bancomambu.service.passive;

import com.mambu.bancomambu.model.account.AccountDTO;
import com.mambu.bancomambu.model.account.BlockAccountDTO;
import reactor.core.publisher.Mono;

public interface BlockAccountService {
    Mono<AccountDTO> blockAccount(String id, BlockAccountDTO blockAccountDTO);
}
