package com.utils.csvToJson.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AccountData {
    private String accountNumber;
    private String custId;
    private String accToken;
    private String currnt;
    private String future;
}
