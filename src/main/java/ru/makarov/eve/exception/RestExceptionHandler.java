package ru.makarov.eve.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.makarov.eve.model.error.ApiErrorsView;

import java.util.Collections;
import java.util.NoSuchElementException;

import static ru.makarov.eve.exception.ErrorMessages.*;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @ExceptionHandler(NoSuchElementException.class)
    protected ResponseEntity<Object> notFound(NoSuchElementException e) {

        return buildApiGlobalErrorResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND, SERVER_NOTFOUND_MSG);
    }

    @ExceptionHandler({CustomEveException.class})
    protected ResponseEntity<Object> serviceUnavailable(HttpStatusCodeException e) {

        switch (e.getStatusCode()) {
            case NOT_FOUND:
                return buildApiGlobalErrorResponseEntity(
                        e.getMessage(),
                        HttpStatus.NOT_FOUND,
                        SERVER_NOTFOUND_MSG);

            case BAD_REQUEST:
                return buildApiGlobalErrorResponseEntity(
                        e.getMessage(),
                        HttpStatus.BAD_REQUEST,
                        SERVER_BAD_REQUEST);

            case GATEWAY_TIMEOUT:
                return buildApiGlobalErrorResponseEntity(
                        e.getMessage(),
                        HttpStatus.GATEWAY_TIMEOUT,
                        SERVER_TIMEOUT);
            default:
                return buildApiGlobalErrorResponseEntity(
                        e.getMessage(),
                        HttpStatus.SERVICE_UNAVAILABLE,
                        SERVER_ERROR_MSG);
        }
    }

    private ResponseEntity<Object> buildApiGlobalErrorResponseEntity(
            ApiGlobalError apiGlobalError,
            HttpStatus httpStatus,
            String error) {


        ApiErrorsView apiErrorsView = ApiErrorsView.builder()
                .fieldErrors(Collections.emptyList())
                .globalErrors(Collections.singletonList(apiGlobalError))
                .error(error)
                .build();

        return new ResponseEntity<>(apiErrorsView, httpStatus);
    }

    private ResponseEntity<Object> buildApiGlobalErrorResponseEntity(
            String message,
            HttpStatus httpStatus,
            String error) {

        return buildApiGlobalErrorResponseEntity(
                ApiGlobalError.builder()
                        .message(message)
                        .build(),
                httpStatus,
                error);
    }
}
