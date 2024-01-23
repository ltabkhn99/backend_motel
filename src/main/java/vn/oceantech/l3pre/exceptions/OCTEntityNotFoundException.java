package vn.oceantech.l3pre.exceptions;

import lombok.Getter;
import vn.oceantech.l3pre.common.ApiMessageError;

@Getter
public class OCTEntityNotFoundException extends L3Exception {
    private ApiMessageError apiMessageError;

    public OCTEntityNotFoundException(ErrorMessages errorMessage) {
        super(errorMessage);
    }

    public OCTEntityNotFoundException(ErrorMessages errorMessage, ApiMessageError apiMessageError) {
        super(errorMessage);
        this.apiMessageError = apiMessageError;
    }
}
