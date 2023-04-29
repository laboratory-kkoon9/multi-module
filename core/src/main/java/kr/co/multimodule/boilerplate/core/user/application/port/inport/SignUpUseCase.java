package kr.co.multimodule.boilerplate.core.user.application.port.inport;

public interface SignUpUseCase {
    void signUp(final SignUpCommand command);

    String validatePhoneNumber(final String phoneNumber);
}
