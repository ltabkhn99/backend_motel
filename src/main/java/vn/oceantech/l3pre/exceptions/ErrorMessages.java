package vn.oceantech.l3pre.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ErrorMessages implements ErrorMessage {
    SUCCESS(200, "Success"),
    BAD_REQUEST(400, "Bad request"),
    UNAUTHORIZED(401, "unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Resource not found"),
    DUPLICATE_DATA(405, "Data duplicate"),
    FILE_UPLOAD_ERROR(406, "File upload error"),
    NOT_ALLOW(406, "Not allow"),
    CONVERT_JSON_ERROR(407, "Convert json error"),
    INVALID_VALUE(422, "Unprocessable Entity"),
    SAVE_DATABASE_ERROR(507, "Insufficient Storage")
    ;

    private final int errorCode;
    private final String errorMessage;
}
