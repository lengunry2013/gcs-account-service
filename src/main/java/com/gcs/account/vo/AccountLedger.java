package com.gcs.account.vo;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AccountLedger {
    private long ledgerID;
    //1: gc
    //2: sc
    private int coinType;
    private long coinInTotal;
    private long coinOutTotal;


}
