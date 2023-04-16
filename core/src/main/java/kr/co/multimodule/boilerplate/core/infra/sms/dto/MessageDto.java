package kr.co.multimodule.boilerplate.core.infra.sms.dto;

import lombok.Getter;

@Getter
public class MessageDto {
    private String to;

    public MessageDto(String to) {
        this.to = to;
    }
}
