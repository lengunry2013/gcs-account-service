package com.gcs.account.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountTransGameBet {
    private long transID;
    private String playerID;
    private String gameSessionID;
    private String playInstanceID;
    private int playInstanceStepID;
    private String gameDeploymentID;
    private String transType;
    private String currencyCode;
    private long coinIn;
    private long coinOut;
    private int coinType;
    private long betStartTime;
    private long betEndTime;
    private long transTime;
    private String operatorID;
}
