package com.mambu.bancomambu.service.active;

import com.mambu.bancomambu.model.product.ProductLoanDTO;
import reactor.core.publisher.Mono;

public interface ProductLoanByIdService {
    Mono<ProductLoanDTO> getAccountById(String loanProductId, String offset, String limit, String paginationDetails,
                                        String detailsLevel);
}
