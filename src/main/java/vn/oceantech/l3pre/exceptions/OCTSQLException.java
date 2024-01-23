package vn.oceantech.l3pre.exceptions;

import lombok.Getter;
import vn.oceantech.l3pre.common.ApiMessageError;

@Getter
public class OCTSQLException extends L3Exception {
    private ApiMessageError apiMessageError;

    public OCTSQLException(ErrorMessages errorMessage) {
        super(errorMessage);
    }

    public OCTSQLException(ErrorMessages errorMessage, ApiMessageError apiMessageError) {
        super(errorMessage);
        this.apiMessageError = apiMessageError;
    }
}
