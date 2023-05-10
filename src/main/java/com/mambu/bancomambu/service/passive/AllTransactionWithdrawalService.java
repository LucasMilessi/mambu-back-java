package com.mambu.bancomambu.service.passive;

import com.mambu.bancomambu.model.transaction.RequestTransactionDTO;
import com.mambu.bancomambu.model.withdrawal.WithdrawalDTO;
import reactor.core.publisher.Flux;

public interface AllTransactionWithdrawalService {
    Flux<WithdrawalDTO> allTransactionWithdrawal(String offset, String limit, String paginationDetails,
                                                 String detailsLevel, RequestTransactionDTO transactionDTO);
}
