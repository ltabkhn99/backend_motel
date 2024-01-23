package vn.oceantech.l3pre.exceptions;

import lombok.Getter;
import vn.oceantech.l3pre.common.ApiMessageError;

@Getter
public class NotAllowException extends L3Exception {
    private final ApiMessageError apiMessageError;

    public NotAllowException(ErrorMessage errorMessage, ApiMessageError apiMessageError) {
        super(errorMessage);
        this.apiMessageError = apiMessageError;
    }
}
