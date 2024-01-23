package vn.oceantech.l3pre.exceptions;

import lombok.Getter;
import vn.oceantech.l3pre.common.ApiMessageError;

@Getter
public class JsonConverterException extends L3Exception {
    private final ApiMessageError apiMessageError;

    public JsonConverterException(ErrorMessage errorMessage, ApiMessageError apiMessageError) {
        super(errorMessage);
        this.apiMessageError = apiMessageError;
    }
}
