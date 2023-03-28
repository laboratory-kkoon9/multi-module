package kr.co.multimodule.boilerplate.core.user.application.port.inport;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@ToString
public class SignUpCommand {
    @NotNull(message = "핸드폰 번호는 필수값입니다.")
    private String phoneNumber;
    @NotNull(message = "이메일은 필수값입니다.")
    private String email;
    @NotNull(message = "이름은 필수값입니다.")
    private String name;
    private String nickname;
}
