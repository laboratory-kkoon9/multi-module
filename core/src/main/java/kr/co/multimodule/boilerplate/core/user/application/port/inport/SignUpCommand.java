package kr.co.multimodule.boilerplate.core.user.application.port.inport;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@ToString
public class SignUpCommand {
    @NotNull
    private String phoneNumber;
    @NotNull
    private String email;
    @NotNull
    private String name;
    private String nickname;
}
