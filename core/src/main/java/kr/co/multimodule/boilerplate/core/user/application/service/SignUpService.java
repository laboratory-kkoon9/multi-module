package kr.co.multimodule.boilerplate.core.user.application.service;

import kr.co.multimodule.boilerplate.core.global.core.exception.BadRequestException;
import kr.co.multimodule.boilerplate.core.global.core.exception.DuplicatePhoneNumberException;
import kr.co.multimodule.boilerplate.core.user.application.port.inport.SignUpCommand;
import kr.co.multimodule.boilerplate.core.user.application.port.inport.SignUpUseCase;
import kr.co.multimodule.boilerplate.core.user.application.port.outport.CreateUserPort;
import kr.co.multimodule.boilerplate.core.user.application.port.outport.LoadUserPort;
import kr.co.multimodule.boilerplate.core.user.domain.User;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static kr.co.multimodule.boilerplate.core.global.core.constants.CodeFormat.HTTP_BAD_REQUEST;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Service
public class SignUpService implements SignUpUseCase {
    private static final String DUPLICATE_PHONE_NUMBER_MESSAGE = "이미 존재하는 핸드폰 번호입니다.";
    private final LoadUserPort loadUserPort;
    private final CreateUserPort createUserPort;

    @Override
    public void signUp(final SignUpCommand command) {
        final String phoneNumber = command.getPhoneNumber();

        if (this.loadUserPort.existByPhoneNumber(phoneNumber)) {
            throw new DuplicatePhoneNumberException(DUPLICATE_PHONE_NUMBER_MESSAGE, HTTP_BAD_REQUEST);
        }

        final User user = User.builder()
                .phoneNumber(command.getPhoneNumber())
                .name(command.getName())
                .email(command.getEmail())
                .nickname(command.getNickname())
                .build();
        this.createUserPort.createUser(user);
    }
}
