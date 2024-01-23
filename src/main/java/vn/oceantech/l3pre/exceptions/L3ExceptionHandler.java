package vn.oceantech.l3pre.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import vn.oceantech.l3pre.common.ApiMessageError;
import vn.oceantech.l3pre.common.ApiSubError;
import vn.oceantech.l3pre.common.ApiValidatorError;
import vn.oceantech.l3pre.common.Response;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
@Slf4j
public class L3ExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidInputException.class)
    protected ResponseEntity<Object> handleInvalidInputException(InvalidInputException invalidInputException) {
        log.info("handleInvalidInputException");
        return new ResponseEntity<>(
                Response.buildResponse(invalidInputException.getErrorMessage(), invalidInputException.getApiSubError()),
                HttpStatus.OK);
    }

    @ExceptionHandler(DuplicateException.class)
    protected ResponseEntity<Object> handleInvalidInputException(DuplicateException duplicateException) {
        log.info("handle duplicate exception");
        return new ResponseEntity<>(
                Response.buildResponse(duplicateException.getErrorMessage(), duplicateException.getApiMessageError()),
                HttpStatus.OK);
    }

    @ExceptionHandler(NotAllowException.class)
    protected ResponseEntity<Object> handleInvalidInputException(NotAllowException notAllowException) {
        log.info("handle not allow exception");
        return new ResponseEntity<>(
                Response.buildResponse(notAllowException.getErrorMessage(), notAllowException.getApiMessageError()),
                HttpStatus.OK);
    }

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Object> handleInvalidInputException(NotFoundException notFoundException) {
        log.info("handle not found exception");
        return new ResponseEntity<>(
                Response.buildResponse(notFoundException.getErrorMessage()),
                HttpStatus.OK);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    protected ResponseEntity<Object> handleInvalidInputException(UsernameNotFoundException usernameNotFoundException) {
        log.info("handle username not found exception");
        return new ResponseEntity<>(
                Response.buildResponse(usernameNotFoundException.getMessage()),
                HttpStatus.OK);
    }

    @ExceptionHandler(JsonConverterException.class)
    protected ResponseEntity<Object> handleInvalidInputException(JsonConverterException jsonConverterException) {
        log.info("handle convert json exception");
        return new ResponseEntity<>(
                Response.buildResponse(jsonConverterException.getErrorMessage(), jsonConverterException.getApiMessageError()),
                HttpStatus.OK);
    }

    @ExceptionHandler(AuthenticateException.class)
    protected ResponseEntity<Object> handleInvalidInputException(AuthenticateException authenticateException) {
        log.info("handle authenticate exception");
        return new ResponseEntity<>(
                Response.buildResponse(authenticateException.getErrorMessage(), authenticateException.getApiMessageError()),
                HttpStatus.OK);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        List<ApiSubError> apiSubErrorList = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            Object rejectedValue = ((FieldError) error).getRejectedValue();
            String message = error.getDefaultMessage();
            apiSubErrorList.add(new ApiValidatorError(fieldName, rejectedValue, message));
        });
        return new ResponseEntity<>(
                Response.buildResponse(ErrorMessages.INVALID_VALUE, apiSubErrorList),
                HttpStatus.OK);
    }

    @ExceptionHandler(L3Exception.class)
    public ResponseEntity<Object> handlerOCTException(L3Exception exception) {
        return new ResponseEntity<>(Response.buildApplicationException(exception), HttpStatus.OK);
    }

    @ExceptionHandler(OCTInvalidInputException.class)
    public ResponseEntity<Object> handlerInvalidInputException(OCTInvalidInputException exception) {
        List<ApiSubError> apiSubErrorList = new ArrayList<>();
        apiSubErrorList.add(exception.getApiValidatorError());
        return new ResponseEntity<>(
                Response.buildResponse(ErrorMessages.INVALID_VALUE, apiSubErrorList),
                HttpStatus.OK);
    }

    @ExceptionHandler(OCTAccessDeniedException.class)
    public ResponseEntity<Object> handlerOCTAccessDeniedException(OCTAccessDeniedException exception) {
        List<ApiSubError> apiSubErrorList = Collections.singletonList(exception.getApiSubError());
        return new ResponseEntity<>(
                Response.buildResponse(exception.getErrorMessage(), apiSubErrorList),
                HttpStatus.OK);
    }

    @ExceptionHandler(OCTValidatorException.class)
    public ResponseEntity<Object> handlerOCTValidatorException(OCTValidatorException exception) {
        List<ApiSubError> apiSubErrorList = Collections.singletonList(exception.getApiMessageError());
        return new ResponseEntity<>(
                Response.buildResponse(exception.getErrorMessage(), apiSubErrorList),
                HttpStatus.OK
        );
    }

    @ExceptionHandler(OCTSQLException.class)
    public ResponseEntity<Object> handlerOCTSQLException(OCTSQLException exception) {
        List<ApiSubError> apiSubErrorList = Collections.singletonList(exception.getApiMessageError());
        return new ResponseEntity<>(
                Response.buildResponse(exception.getErrorMessage(), apiSubErrorList),
                HttpStatus.OK
        );
    }

    @ExceptionHandler(OCTEntityNotFoundException.class)
    public ResponseEntity<Object> handlerOCTEntityNotFoundException(OCTEntityNotFoundException exception) {
        List<ApiSubError> apiSubErrorList = Collections.singletonList(exception.getApiMessageError());
        return new ResponseEntity<>(
                Response.buildResponse(exception.getErrorMessage(), apiSubErrorList),
                HttpStatus.OK
        );
    }

    @ExceptionHandler(OCTInvalidOperationException.class)
    public ResponseEntity<Object> handlerOCTInvalidOperationException(OCTInvalidOperationException exception) {
        List<ApiSubError> apiSubErrorList = Collections.singletonList(exception.getApiSubError());
        return new ResponseEntity<>(
                Response.buildResponse(exception.getErrorMessage(), apiSubErrorList),
                HttpStatus.OK);
    }

    @ExceptionHandler(GenericJDBCException.class)
    public ResponseEntity<Object> handlerGenericJDBCException(GenericJDBCException exception) {
        ApiMessageError apiMessageError = new ApiMessageError(exception.getMessage());
        List<ApiSubError> apiSubErrorList = Collections.singletonList(apiMessageError);
        return new ResponseEntity<>(
                Response.buildResponse(ErrorMessages.BAD_REQUEST, apiSubErrorList),
                HttpStatus.OK);
    }
}
