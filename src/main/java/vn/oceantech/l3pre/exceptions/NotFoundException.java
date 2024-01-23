package vn.oceantech.l3pre.exceptions;

import lombok.Getter;

@Getter
public class NotFoundException extends L3Exception {
    public NotFoundException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
