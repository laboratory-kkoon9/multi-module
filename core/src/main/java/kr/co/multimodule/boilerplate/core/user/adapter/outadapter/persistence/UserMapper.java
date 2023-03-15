package kr.co.multimodule.boilerplate.core.user.adapter.outadapter.persistence;

import kr.co.multimodule.boilerplate.core.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    UserJpaEntity mapToJpaEntity(final User user) {
        System.out.println("[UserMapper] User to UserJpaEntity");
        return UserJpaEntity.builder()
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .name(user.getName())
                .nickname(user.getNickname())
                .build();
    }
}
