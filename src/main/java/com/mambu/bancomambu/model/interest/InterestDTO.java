package com.mambu.bancomambu.model.interest;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InterestDTO {

    private String interestApplicationDate;
    private String notes;
}
