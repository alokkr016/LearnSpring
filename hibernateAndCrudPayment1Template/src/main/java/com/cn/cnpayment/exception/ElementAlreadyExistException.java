package com.cn.cnpayment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//add proper annotation for this custom exception class
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ElementAlreadyExistException extends Exception {

    public ElementAlreadyExistException() {
        super();
    }

    public ElementAlreadyExistException(String message) {
        super(message);
    }
}
