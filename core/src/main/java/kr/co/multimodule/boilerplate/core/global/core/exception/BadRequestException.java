package kr.co.multimodule.boilerplate.core.global.core.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Getter
public abstract class BadRequestException extends RuntimeException {
    private String errorCode;
    private String message;

    public BadRequestException(final Throwable exception) {
        super(exception);
    }

    public BadRequestException(final String message, final Throwable exception) {
        super(message, exception);
        this.message = message;
    }

    public BadRequestException(final String message, String errorCode, final Throwable exception) {
        super(message, exception);
        this.message = message;
        this.errorCode = errorCode;
    }

    public BadRequestException(final String message) {
        super(message);
        this.message = message;
    }

    public BadRequestException(final String message, String errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }

    public BadRequestException(final String message, int errorCode) {
        super(message);
        this.message = message;
        this.errorCode = Integer.toString(errorCode);
    }

    public static ResponseStatusException raise(String message) {
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
    }
}
