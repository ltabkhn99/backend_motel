package vn.oceantech.l3pre.common;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ApiValidatorError implements ApiSubError{
    private String field;
    private Object rejectValue;
    private String message;
}
