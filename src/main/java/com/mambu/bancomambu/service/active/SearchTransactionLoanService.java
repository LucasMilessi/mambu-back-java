package com.mambu.bancomambu.service.active;

import com.mambu.bancomambu.model.loan.LoanAccountResponseDTO;
import com.mambu.bancomambu.model.transaction.RequestTransactionDTO;
import reactor.core.publisher.Flux;

public interface SearchTransactionLoanService {

    Flux<LoanAccountResponseDTO> searchTransactionPay(String offset, String limit, String paginationDetails,
                                                      String detailsLevel, RequestTransactionDTO requestTransactionDTO);
}
