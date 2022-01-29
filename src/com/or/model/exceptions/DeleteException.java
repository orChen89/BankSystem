package com.or.model.exceptions;

import java.util.Date;

public class DeleteException extends Exception{

    private Date timeStamp;

    public DeleteException(Date timeStamp) {
        super("Unfortunately, we can't delete a client with a debt to the bank " + timeStamp.toString());
        this.timeStamp = timeStamp;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
