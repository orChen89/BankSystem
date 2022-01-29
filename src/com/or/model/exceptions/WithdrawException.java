package com.or.model.exceptions;

import java.util.Date;

public class WithdrawException extends Exception{

    private Date timeStamp;

    public WithdrawException(Date timeStamp) {
        super("Unfortunately, you don't have the sufficient balance!" + timeStamp.toString());
        this.timeStamp = timeStamp;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
