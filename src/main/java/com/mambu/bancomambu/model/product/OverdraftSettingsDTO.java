package com.mambu.bancomambu.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OverdraftSettingsDTO {

    private boolean allowOverdraft;
    private long maxOverdraftLimit;
    private boolean allowTechnicalOverdraft;
}
