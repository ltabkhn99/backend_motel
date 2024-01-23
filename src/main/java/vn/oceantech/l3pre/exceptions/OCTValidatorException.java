package vn.oceantech.l3pre.exceptions;

import lombok.Getter;
import vn.oceantech.l3pre.common.ApiMessageError;

@Getter
public class OCTValidatorException extends L3Exception {
    private ApiMessageError apiMessageError;

    public OCTValidatorException(ErrorMessages errorMessage) {
        super(errorMessage);
    }

    public OCTValidatorException(ErrorMessages errorMessage, ApiMessageError apiMessageError) {
        super(errorMessage);
        this.apiMessageError = apiMessageError;
    }
}
