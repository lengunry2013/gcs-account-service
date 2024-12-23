package com.gcs.account.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PlayerInfo {
    private String playerID="";
    private String firstName;
    private String lastName;
    private String sex="0";
    private Date dateOfBirth;
    private String country;
    private String defaultCurrencyCode;
    private String email;
    private int state;
    private String password;
    private String photoID;
    private String operatorID;
    private String residentialAddress;

}
