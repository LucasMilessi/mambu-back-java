package com.mambu.bancomambu.model.passiveAnnexe;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlockAndSeizeRequestDTO {

    private long amount;

    private String externalReferenceId;

    private String notes;

    private String transactionChannelId;

    private String externalId;

    private String notesSeize;
}
