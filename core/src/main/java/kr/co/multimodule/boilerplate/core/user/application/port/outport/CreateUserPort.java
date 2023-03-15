package kr.co.multimodule.boilerplate.core.user.application.port.outport;

import kr.co.multimodule.boilerplate.core.user.domain.User;

public interface CreateUserPort {
    void createUser(User user);
}
