package com.mambu.bancomambu.service.active.impl;

import com.mambu.bancomambu.model.ErrorDTO;
import com.mambu.bancomambu.model.loan.*;
import com.mambu.bancomambu.model.product.ProductLoanDTO;
import com.mambu.bancomambu.service.active.ProductLoanByIdService;
import com.mambu.bancomambu.service.active.RefinanceLoanService;
import com.mambu.bancomambu.service.active.RescheduleLoanService;
import com.mambu.bancomambu.service.active.ValidateProductService;
import com.mambu.bancomambu.util.ValidateProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static com.mambu.bancomambu.model.StatusErrorEnum.INSTALLMENTS;
import static com.mambu.bancomambu.model.StatusErrorEnum.INTEREST_RATE;

@Service
public class ValidateProductServiceImpl implements ValidateProductService {

    @Autowired
    private ProductLoanByIdService productLoanByIdService;

    @Autowired
    private RefinanceLoanService refinanceLoanService;

    @Autowired
    private ValidateProductUtil validateProductUtil;

    @Autowired
    private RescheduleLoanService rescheduleLoanService;

    private final String OFFSET = "0";
    private final String LIMIT = "10";
    private final String PAGINATIONDETAILS = "OFF";
    private final String DETAILSLEVEL = "FULL";
    private final String IDPRODUCTO = "microcredcol";


    @Override
    public Mono<ResponseAccountDTO> validateRefinance(String id, RefinanceDTO refinanceDTO){

        return productLoanByIdService.getAccountById(IDPRODUCTO, OFFSET, LIMIT,
                PAGINATIONDETAILS, DETAILSLEVEL).flatMap( product -> {

                if(refinanceDTO.getLoanAccount() == null){
                    refinanceDTO.setLoanAccount(createLoanAccountDTO(product));
                }

                double interestRate = refinanceDTO.getLoanAccount().getInterestSettings().getInterestRate();

                if(validateProductUtil.validateRefinanceInterest(product, interestRate)){

                    String min = String.valueOf(product.getInterestSettings().getIndexRateSettings().getInterestRate().getMinValue());
                    String max = String.valueOf(product.getInterestSettings().getIndexRateSettings().getInterestRate().getMaxValue());

                    var error = ErrorDTO.builder()
                            .code(INTEREST_RATE.getCode())
                            .description(INTEREST_RATE.getDescription() + min +" y "+ max)
                            .httpStatus(INTEREST_RATE.getHttpStatus())
                            .build();

                    return Mono.error(new Throwable(error.getDescription()));
                }

                long repaymentInstallments = refinanceDTO.getLoanAccount().getScheduleSettings().getRepaymentInstallments();

                if(validateProductUtil.validateRefinanceInstallments(product, repaymentInstallments)){

                    String min = String.valueOf(product.getScheduleSettings().getNumInstallments().getMaxValue());
                    String max = String.valueOf(product.getScheduleSettings().getNumInstallments().getMinValue());

                    var error = ErrorDTO.builder()
                            .code(INSTALLMENTS.getCode())
                            .description(INSTALLMENTS.getDescription() + min +" y "+ max)
                            .httpStatus(INSTALLMENTS.getHttpStatus())
                            .build();

                    return Mono.error(new Throwable(error.getDescription()));
                }

                return refinanceLoanService.refinanceLoan(id, refinanceDTO);
        });
    }

    @Override
    public Mono<ResponseAccountDTO> validateReschedule(String id, RescheduleDTO rescheduleDTO){

        return productLoanByIdService.getAccountById(IDPRODUCTO, OFFSET, LIMIT,
                PAGINATIONDETAILS, DETAILSLEVEL).flatMap( product -> {

            if(rescheduleDTO == null){
                var rescheduleResponse = RescheduleDTO.builder()
                        .loanAccount(createLoanAccountDTO(product))
                        .build();
                return rescheduleLoanService.rescheduleLoan(id, rescheduleResponse);
            }

            double interestRate = rescheduleDTO.getLoanAccount().getInterestSettings().getInterestRate();

            if(validateProductUtil.validateRefinanceInterest(product, interestRate)){

                String min = String.valueOf(product.getInterestSettings().getIndexRateSettings().getInterestRate().getMinValue());
                String max = String.valueOf(product.getInterestSettings().getIndexRateSettings().getInterestRate().getMaxValue());

                var error = ErrorDTO.builder()
                        .code(INTEREST_RATE.getCode())
                        .description(INTEREST_RATE.getDescription() + min +" y "+ max)
                        .httpStatus(INTEREST_RATE.getHttpStatus())
                        .build();

                return Mono.error(new Throwable(error.getDescription()));
            }

            long repaymentInstallments = rescheduleDTO.getLoanAccount().getScheduleSettings().getRepaymentInstallments();

            if(validateProductUtil.validateRefinanceInstallments(product, repaymentInstallments)){

                String min = String.valueOf(product.getScheduleSettings().getNumInstallments().getMaxValue());
                String max = String.valueOf(product.getScheduleSettings().getNumInstallments().getMinValue());

                var error = ErrorDTO.builder()
                        .code(INSTALLMENTS.getCode())
                        .description(INSTALLMENTS.getDescription() + min +" y "+ max)
                        .httpStatus(INSTALLMENTS.getHttpStatus())
                        .build();

                return Mono.error(new Throwable(error.getDescription()));
            }

            return rescheduleLoanService.rescheduleLoan(id, rescheduleDTO);
        });
    }

    private LoanAccountDTO createLoanAccountDTO(ProductLoanDTO product){

        var disbursementDetails = DisbursementDetailsDTO.builder()
                .firstRepaymentDate(futureDate())
                .build();

        var interest = InterestLoanSettingsDTO.builder()
                .interestRate(product.getInterestSettings().getIndexRateSettings().getInterestRate().getDefaultValue())
                .build();

        var schedule = ScheduleSettingsDTO.builder()
                .gracePeriod(0)
                .repaymentInstallments(product.getScheduleSettings().getNumInstallments().getDefaultValue())
                .build();

        var loanAccount = LoanAccountDTO.builder()
                .productTypeKey(product.getEncodedKey())
                .disbursementDetails(disbursementDetails)
                .interestSettings(interest)
                .scheduleSettings(schedule)
                .build();

        return loanAccount;
    }

    private String futureDate() {
        OffsetDateTime date = OffsetDateTime.now(ZoneOffset.of("-05:00")).plusDays(15).minusSeconds(1);
        String dateNow = date.toString();
        return dateNow;
    }
}
