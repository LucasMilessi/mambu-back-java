package com.mambu.bancomambu.util;

import com.mambu.bancomambu.model.loan.RefinanceDTO;
import com.mambu.bancomambu.model.product.ProductLoanDTO;

public interface ValidateProductUtil {
    boolean validateRefinanceInterest(ProductLoanDTO productLoanDTO, double interestRate);

    boolean validateRefinanceInstallments(ProductLoanDTO productLoanDTO, long repaymentInstallments);
}
