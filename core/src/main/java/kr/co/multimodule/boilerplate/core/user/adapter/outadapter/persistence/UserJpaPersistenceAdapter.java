package kr.co.multimodule.boilerplate.core.user.adapter.outadapter.persistence;

import kr.co.multimodule.boilerplate.core.user.application.port.outport.CreateUserPort;
import kr.co.multimodule.boilerplate.core.user.application.port.outport.LoadUserPort;
import kr.co.multimodule.boilerplate.core.user.domain.User;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Service
public class UserJpaPersistenceAdapter implements
        LoadUserPort,
        CreateUserPort {
    private final UserJpaRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Boolean existByPhoneNumber(final String phoneNumber) {
        System.out.println("[UserJpaPersistenceAdapter] existByPhoneNumber");
        return this.userRepository.existsByPhoneNumber(phoneNumber);
    }

    @Override
    public void createUser(final User user) {
        System.out.println("[UserJpaPersistenceAdapter] createUser");
        UserJpaEntity userJpaEntity = userMapper.mapToJpaEntity(user);
        this.userRepository.save(userJpaEntity);
        System.out.println(userJpaEntity.toString() + " DB 저장 완료");

    }
}
