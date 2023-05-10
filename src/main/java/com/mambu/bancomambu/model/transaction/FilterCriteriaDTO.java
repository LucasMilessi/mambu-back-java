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
public class FilterCriteriaDTO {

    private String field;
    private String operator;
    private String secondValue;
    private String value;
    private List<String> values;
}
