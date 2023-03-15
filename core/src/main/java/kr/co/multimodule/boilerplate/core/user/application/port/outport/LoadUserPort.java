package kr.co.multimodule.boilerplate.core.user.application.port.outport;

public interface LoadUserPort {
    Boolean existByPhoneNumber(final String phoneNumber);
}
