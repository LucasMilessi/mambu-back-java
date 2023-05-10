package com.mambu.bancomambu.service.passive;

import com.mambu.bancomambu.model.account.AccountDTO;
import reactor.core.publisher.Mono;

public interface CreateAccountClienteService {
    Mono<AccountDTO> createAccount(AccountDTO accountDTO);
}
