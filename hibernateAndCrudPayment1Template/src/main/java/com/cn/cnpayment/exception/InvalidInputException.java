package com.cn.cnpayment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//add proper annotation for this custom exception class
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidInputException extends Exception {

    // complete the method body for this custom exception
    public InvalidInputException(String msg)
    {
        super(msg);
    }

}
