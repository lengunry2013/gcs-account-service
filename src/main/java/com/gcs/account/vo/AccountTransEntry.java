package com.gcs.account.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountTransEntry {
    private long transID;
    private long ledgerID;
    private String currencyCode;
    private int coinType;
    private long coinIn;
    private long coinOut;
}
