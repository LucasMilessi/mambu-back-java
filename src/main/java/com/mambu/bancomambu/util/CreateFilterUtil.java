package com.mambu.bancomambu.util;

import com.mambu.bancomambu.model.transaction.RequestTransactionDTO;

public interface CreateFilterUtil {
    RequestTransactionDTO createFilterPago(String encodedKey);

    RequestTransactionDTO createFilterDisbursement(String encodedKey);
}
