package com.bankaya.core.exeptions;

import com.bankaya.core.errors.ErrorCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class InternalServerErrorException extends AbstractBankayaException{

    public InternalServerErrorException(ErrorCode errorCode) {
        super(errorCode);
    }

    public InternalServerErrorException(String message) {
        super(message);
    }

    public InternalServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalServerErrorException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public InternalServerErrorException(Throwable cause) {
        super(cause);
    }


}
