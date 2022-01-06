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

import static ru.makarov.eve.exception.ErrorMessages.SERVER_ERROR_MSG;

@Slf4j
@ControllerAdvice
//todo доделать обработчик ошибок
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @ExceptionHandler(NoSuchElementException.class)
    protected ResponseEntity<Object> notFound(NoSuchElementException e) {

        return buildApiGlobalErrorResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND, SERVER_ERROR_MSG);
    }

    @ExceptionHandler({HttpStatusCodeException.class})
    protected ResponseEntity<Object> serviceUnavailable(HttpStatusCodeException e) {
        log.error("Exception occurred: ", e);

        switch (e.getStatusCode()) {
            case NOT_FOUND:
                return buildApiGlobalErrorResponseEntity(
                        e.getMessage(),
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        SERVER_ERROR_MSG);
            default:
                return buildApiGlobalErrorResponseEntity(
                        e.getMessage(),
                        HttpStatus.SERVICE_UNAVAILABLE,
                        SERVER_ERROR_MSG);
        }
    }

    public ResponseEntity<Object> buildApiGlobalErrorResponseEntity(
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
