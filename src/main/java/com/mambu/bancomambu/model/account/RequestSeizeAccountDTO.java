package com.mambu.bancomambu.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestSeizeAccountDTO {

    private long amount;
    private String blockId;
    private String externalId;
    private String notes;
    private String transactionChannelId;
}
