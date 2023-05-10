package com.mambu.bancomambu.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlockFundsResponseDTO {

    private long amount;
    private String externalReferenceId;
    private String accountKey;
    private String state;
    private long seizedAmount;
    private OffsetDateTime creationDate;
    private OffsetDateTime lastModifiedDate;
    private String notes;
}
