package com.cn.cnpayment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//add proper annotation for this custom exception class
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {

    //complete the method body for this custom exception
    public NotFoundException(String msg)
    {
        super(msg);
    }
}
