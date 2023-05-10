package com.mambu.bancomambu.model.passiveAnnexe;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mambu.bancomambu.model.transaction.FilterCriteriaDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplyInterestRequestDTO {

    private FilterCriteriaDTO[] filterCriteria;
    private String interestApplicationDate;
    private String notes;
}
