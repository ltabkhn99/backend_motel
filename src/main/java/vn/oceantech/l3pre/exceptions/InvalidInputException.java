package vn.oceantech.l3pre.exceptions;

import lombok.Getter;
import vn.oceantech.l3pre.common.ApiSubError;

@Getter
public class InvalidInputException extends L3Exception {
    private final ApiSubError apiSubError;

    public InvalidInputException(ErrorMessage errorMessage, ApiSubError apiSubError) {
        super(errorMessage);
        this.apiSubError = apiSubError;
    }
}
