package kr.co.multimodule.boilerplate.core.user.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User {
    private Long id;
    private String phoneNumber;
    private String email;
    private String name;
    private String nickname;

    @Builder
    public User(Long id, String phoneNumber, String email, String name, String nickname) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.name = name;
        this.nickname = nickname;
    }
}
