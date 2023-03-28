package kr.co.multimodule.boilerplate.api.global.core.exception;

import java.util.Optional;
import kr.co.multimodule.boilerplate.api.global.response.ErrorResponse;
import kr.co.multimodule.boilerplate.core.global.core.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException e) {
        String message = Optional.ofNullable(e.getMessage()).orElseGet(() -> "올바른 요청이 아닙니다. ");
        String errorCode = Optional.ofNullable(e.getErrorCode()).orElseGet(() -> "400");

        ErrorResponse errorResponse = new ErrorResponse(Integer.parseInt(errorCode), message);
        return ResponseEntity.ok().body(errorResponse);
    }

    @ExceptionHandler(BindException.class)
    protected ResponseEntity<ErrorResponse> handleBindException(BindException e) {
        log.warn("BindException: ", e);
        BindingResult bindingResult = e.getBindingResult();

        StringBuilder builder = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            builder.append("[");
            builder.append(fieldError.getField());
            builder.append("]의 값이 올바른 형식이 아닙니다. 입력된 값: [");
            builder.append(fieldError.getRejectedValue());
            builder.append("]");
        }
        String message = builder.toString();

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), message);
        return ResponseEntity.ok().body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.warn("@Valid MethodArgumentNotValidException: ", e);
        BindingResult bindingResult = e.getBindingResult();

        StringBuilder builder = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            builder.append("[");
            builder.append(fieldError.getField());
            builder.append("](은)는 ");
            builder.append(fieldError.getDefaultMessage());
            builder.append(" 입력된 값: [");
            builder.append(fieldError.getRejectedValue());
            builder.append("] ");
        }
        String message = builder.toString();

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), message);
        return ResponseEntity.ok().body(errorResponse);
    }
}
