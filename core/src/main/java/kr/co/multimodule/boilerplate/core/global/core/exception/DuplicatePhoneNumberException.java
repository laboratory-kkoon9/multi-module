package kr.co.multimodule.boilerplate.core.global.core.exception;

public class DuplicatePhoneNumberException extends BadRequestException {
    public DuplicatePhoneNumberException(Throwable exception) {
        super(exception);
    }

    public DuplicatePhoneNumberException(String message, Throwable exception) {
        super(message, exception);
    }

    public DuplicatePhoneNumberException(String message, String errorCode, Throwable exception) {
        super(message, errorCode, exception);
    }

    public DuplicatePhoneNumberException(String message) {
        super(message);
    }

    public DuplicatePhoneNumberException(String message, String errorCode) {
        super(message, errorCode);
    }

    public DuplicatePhoneNumberException(String message, int errorCode) {
        super(message, errorCode);
    }
}
