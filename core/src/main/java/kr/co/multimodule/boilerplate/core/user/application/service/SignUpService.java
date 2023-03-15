package kr.co.multimodule.boilerplate.core.user.application.service;

import kr.co.multimodule.boilerplate.core.user.application.port.inport.SignUpCommand;
import kr.co.multimodule.boilerplate.core.user.application.port.inport.SignUpUseCase;
import kr.co.multimodule.boilerplate.core.user.application.port.outport.CreateUserPort;
import kr.co.multimodule.boilerplate.core.user.application.port.outport.LoadUserPort;
import kr.co.multimodule.boilerplate.core.user.domain.User;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Service
public class SignUpService implements SignUpUseCase {
    private final LoadUserPort loadUserPort;
    private final CreateUserPort createUserPort;

    @Override
    public void signUp(final SignUpCommand command) {
        final String phoneNumber = command.getPhoneNumber();
        System.out.println("phoneNumber : " + phoneNumber);
        if (this.loadUserPort.existByPhoneNumber(phoneNumber)) {
            System.out.println("이미 존재하는 핸드폰 번호입니다.");
            // Exception
        }

        final User user = User.builder()
                .phoneNumber(command.getPhoneNumber())
                .name(command.getName())
                .email(command.getEmail())
                .nickname(command.getNickname())
                .build();
        System.out.println(user.toString());
        this.createUserPort.createUser(user);
    }
}
