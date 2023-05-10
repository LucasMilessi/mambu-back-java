package com.mambu.bancomambu.service.passive;

import com.mambu.bancomambu.model.transaction.TransactionDTO;
import reactor.core.publisher.Flux;

public interface GetLastMovementService {
    Flux<TransactionDTO> getLastTransactions(String id, String limit, String detailsLevel) throws Exception;
}
