package com.bankaya.core.exeptions;

import com.bankaya.core.errors.ErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractBankayaException extends RuntimeException{


    private ErrorCode errorCode;

    public AbstractBankayaException() {
    }

    public AbstractBankayaException(String message) {
        super(message);
    }

    public AbstractBankayaException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractBankayaException(Throwable cause) {
        super(cause);
    }

    public AbstractBankayaException(ErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
    }

    public AbstractBankayaException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

}
