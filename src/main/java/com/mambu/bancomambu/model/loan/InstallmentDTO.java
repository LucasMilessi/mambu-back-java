package com.mambu.bancomambu.model.loan;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InstallmentDTO {

    private String encodedKey;
    private String parentAccountKey;
    private String number;
    private OffsetDateTime dueDate;
    private String state;
    private boolean isPaymentHoliday;
    private PrincipalDTO principal;
    private PrincipalDTO interest;

}
