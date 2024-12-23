package com.gcs.account.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountTrans {
    private long transID;
    private String transTypeID;
    private long createDate;
    private long bookDate;
    private long revokeDate;
    private int state;
}
