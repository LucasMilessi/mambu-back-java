package com.mambu.bancomambu.service.passive;

import com.mambu.bancomambu.model.transaction.RequestTransactionDTO;
import com.mambu.bancomambu.model.transaction.TransactionDTO;
import reactor.core.publisher.Flux;

public interface AllTransactionDepositService {
    Flux<TransactionDTO> allTransaction(String offset, String limit, String paginationDetails,
                                        String detailsLevel, RequestTransactionDTO transactionDTO);
}
