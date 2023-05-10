package com.mambu.bancomambu.service.passive;

import com.mambu.bancomambu.model.account.BlockConsultantDTO;
import com.mambu.bancomambu.model.transaction.RequestTransactionDTO;
import reactor.core.publisher.Flux;

public interface AccountBlockingConsultantService {
    Flux<BlockConsultantDTO> blockingConsultant(RequestTransactionDTO transactionDTO);
}
