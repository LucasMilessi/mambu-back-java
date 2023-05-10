package com.mambu.bancomambu.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OverdraftSettingsBlockDTO {

    private boolean allowOverdraft;
    private long overdraftLimit;
}
