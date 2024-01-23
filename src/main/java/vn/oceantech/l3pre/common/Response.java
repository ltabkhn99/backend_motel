package vn.oceantech.l3pre.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import vn.oceantech.l3pre.exceptions.ErrorMessage;
import vn.oceantech.l3pre.exceptions.ErrorMessages;
import vn.oceantech.l3pre.exceptions.L3Exception;
import vn.oceantech.l3pre.constants.DateHelper;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Response<T> {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateHelper.GLOBAL_DATE)
    private final LocalDateTime timestamp = LocalDateTime.now();
    private int code;
    private String message;
    private List<ApiSubError> details;
    private ApiSubError apiSubError;
    private T data;
    private int total;

    public static <T> Response<T> buildResponse(ErrorMessage errorMessage) {
        Response<T> response = new Response<>();
        response.code = errorMessage.getErrorCode();
        response.message = errorMessage.getErrorMessage();
        return response;
    }

    public static <T> Response<T> buildResponse() {
        Response<T> response = new Response<>();
        response.code = ErrorMessages.SUCCESS.getErrorCode();
        response.message = ErrorMessages.SUCCESS.getErrorMessage();
        return response;
    }

    public static <T> Response<T> buildResponse(ErrorMessage errorMessage, List<ApiSubError> details) {
        Response<T> response = buildResponse(errorMessage);
        response.details = details;
        return response;
    }

    public static <T> Response<T> buildResponse(ErrorMessage errorMessage, ApiSubError apiSubError) {
        Response<T> response = buildResponse(errorMessage);
        response.apiSubError = apiSubError;
        return response;
    }

    public static <T> Response<T> buildResponse(String message) {
        Response<T> response = new Response<>();
        response.message = message;
        return response;
    }
    public static <T> Response<T> buildResponse(T data) {
        Response<T> response = new Response<>();
        response.data = data;
        response.code = 200;
        return response;
    }

    public static <T> Response<T> buildResponse(Integer total) {
        Response<T> response = new Response<>();
        response.code = 200;
        response.total = total;
        return response;
    }

    public static <T> Response<T> buildResponse(T data, Integer total) {
        Response<T> response = buildResponse(data);
        response.total = total;
        response.code = 200;
        return response;
    }

    public static <T> Response<T> buildResponse(T data, ErrorMessage errorMessage) {
        Response<T> response = buildResponse(errorMessage);
        response.data = data;
        return response;
    }

    public static <T> Response<T> buildResponse(T data, Integer total, String message, Integer errCode) {
        Response<T> response = buildResponse(data, total);
        response.code = errCode;
        response.message = message;
        return response;
    }

    public static Response<String> buildApplicationException(L3Exception exception) {
        return buildResponse(exception.getErrorMessage());
    }
}
