package vn.oceantech.l3pre.exceptions;

import lombok.Getter;
import vn.oceantech.l3pre.common.ApiSubError;

@Getter
public class OCTInvalidOperationException extends L3Exception {
    private ApiSubError apiSubError;

    public OCTInvalidOperationException(ErrorMessage errorMessage) {
        super(errorMessage);
    }

    public OCTInvalidOperationException(ErrorMessage errorMessage, ApiSubError apiSubError) {
        super(errorMessage);
        this.apiSubError = apiSubError;
    }
}
