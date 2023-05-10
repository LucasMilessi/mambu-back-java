package com.mambu.bancomambu.service.passive;

import com.mambu.bancomambu.model.account.AccountDTO;
import com.mambu.bancomambu.model.transaction.RequestTransactionDTO;
import reactor.core.publisher.Flux;

public interface SearchTransactionInterestService {
    Flux<AccountDTO> serchTransactionInterest(String offset, String limit, String paginationDetails,
                                              String detailsLevel, RequestTransactionDTO transactionDTO);
}
