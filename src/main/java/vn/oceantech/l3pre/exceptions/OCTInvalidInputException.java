package vn.oceantech.l3pre.exceptions;

import lombok.Getter;
import vn.oceantech.l3pre.common.ApiValidatorError;

@Getter
public class OCTInvalidInputException extends L3Exception {
    private ApiValidatorError apiValidatorError;

    public OCTInvalidInputException(ErrorMessage errorMessage) {
        super(errorMessage);
    }

    public OCTInvalidInputException(ErrorMessage errorMessage, ApiValidatorError apiInvalidInputError) {
        super(errorMessage);
        this.apiValidatorError = apiInvalidInputError;
    }
}
