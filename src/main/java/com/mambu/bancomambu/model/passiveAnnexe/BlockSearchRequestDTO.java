package com.mambu.bancomambu.model.passiveAnnexe;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mambu.bancomambu.model.transaction.FilterCriteriaDTO;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlockSearchRequestDTO {

    private String action;
    private String notes;
    private FilterCriteriaDTO[] filterCriteria;
}
