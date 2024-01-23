package vn.oceantech.l3pre.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class L3Exception extends RuntimeException {
    private final ErrorMessage errorMessage;

    public L3Exception(ErrorMessage errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }
}
