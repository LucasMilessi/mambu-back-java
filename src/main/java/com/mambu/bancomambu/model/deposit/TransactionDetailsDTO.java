package com.mambu.bancomambu.model.deposit;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDetailsDTO {

    private String transactionChannelKey;
    private String transactionChannelId;
}
