package com.mambu.bancomambu.model.loan;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mambu.bancomambu.model.product.CurrencyDTO;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountPlanDTO {

    private List<InstallmentDTO> installments;
    private CurrencyDTO currency;
}
