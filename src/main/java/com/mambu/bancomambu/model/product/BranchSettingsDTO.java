package com.mambu.bancomambu.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BranchSettingsDTO {

    private boolean forAllBranches;
    private List<Object> availableProductBranches;
}
