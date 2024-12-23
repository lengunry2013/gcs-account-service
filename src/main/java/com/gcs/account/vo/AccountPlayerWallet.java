package com.gcs.account.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountPlayerWallet {
    private long ledgerID;
    private int coinType;
    private String playerID;
}
