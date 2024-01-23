package vn.oceantech.l3pre.exceptions;

import lombok.Getter;
import vn.oceantech.l3pre.common.ApiSubError;

@Getter
public class OCTAccessDeniedException extends L3Exception {
    private ApiSubError apiSubError;

    public OCTAccessDeniedException(ErrorMessage errorMessage) {
        super(errorMessage);
    }

    public OCTAccessDeniedException(ErrorMessage errorMessage, ApiSubError apiSubError) {
        super(errorMessage);
        this.apiSubError = apiSubError;
    }
}
