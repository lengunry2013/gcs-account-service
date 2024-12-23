package com.gcs.account.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountTransGatewayTransfer {
    private long transID;
    private String playerID;
    private int gatewayType;
    private long walletBalanceBeforeGc;
    private long walletBalanceAfterGc;
    private long walletBalanceBeforeSc;
    private long walletBalanceAfterSc;
    private String currencyCode;
    private long cashAmount;

}
