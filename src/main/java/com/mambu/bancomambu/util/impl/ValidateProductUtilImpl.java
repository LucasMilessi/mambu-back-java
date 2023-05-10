package com.mambu.bancomambu.util.impl;

import com.mambu.bancomambu.model.loan.RefinanceDTO;
import com.mambu.bancomambu.model.product.ProductLoanDTO;
import com.mambu.bancomambu.util.ValidateProductUtil;
import org.springframework.stereotype.Service;

@Service
public class ValidateProductUtilImpl implements ValidateProductUtil {

    @Override
    public boolean validateRefinanceInterest(ProductLoanDTO productLoanDTO, double interestRate){

        if((productLoanDTO.getInterestSettings().getIndexRateSettings().getInterestRate().getMaxValue() < interestRate)
                || (productLoanDTO.getInterestSettings().getIndexRateSettings().getInterestRate().getMinValue() > interestRate)){
            return true;
        }
        return false;
    }

    @Override
    public boolean validateRefinanceInstallments(ProductLoanDTO productLoanDTO, long repaymentInstallments){

        if((productLoanDTO.getScheduleSettings().getNumInstallments().getMaxValue() < repaymentInstallments) ||
                (productLoanDTO.getScheduleSettings().getNumInstallments().getMinValue() > repaymentInstallments)){
            return true;
        }
        return false;
    }
}
