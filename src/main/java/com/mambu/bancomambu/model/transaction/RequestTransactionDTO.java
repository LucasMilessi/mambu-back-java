package com.mambu.bancomambu.model.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestTransactionDTO {

    private List<FilterCriteriaDTO> filterCriteria;
    private SortingCriteriaDTO sortingCriteria;
}
