package com.mambu.bancomambu.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InterestRateDTO {

    private long minValue;
    private long maxValue;
    private long defaultValue;
}
