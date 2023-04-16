package kr.co.multimodule.boilerplate.core.global.core.exception;

public class SignatureException extends BadRequestException {
    public SignatureException(Throwable exception) {
        super(exception);
    }

    public SignatureException(String message, Throwable exception) {
        super(message, exception);
    }

    public SignatureException(String message, String errorCode, Throwable exception) {
        super(message, errorCode, exception);
    }

    public SignatureException(String message) {
        super(message);
    }

    public SignatureException(String message, String errorCode) {
        super(message, errorCode);
    }

    public SignatureException(String message, int errorCode) {
        super(message, errorCode);
    }
}