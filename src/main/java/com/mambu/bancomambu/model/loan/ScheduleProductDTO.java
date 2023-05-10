package com.mambu.bancomambu.model.loan;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScheduleProductDTO {

    private NumInstallmentDTO numInstallments;
}
