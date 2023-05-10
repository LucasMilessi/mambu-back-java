package com.mambu.bancomambu.service.active;

import com.mambu.bancomambu.model.loan.PaymentDebtDTO;
import reactor.core.publisher.Mono;

public interface FullDebtPaymentService {

    Mono<Object> paymentDebt(String id);
}
