package com.mambu.bancomambu.model.loan;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmountDTO {

    private double expected;
    private double paid;
    private double due;
}
