package kr.co.multimodule.boilerplate.core.infra.sms.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class SmsNcpDto {
    private String type = "SMS";
    private String contentType = "COMM";
    private String countryCode = "82";
    private String subject = "인증 알림";
    private String from;
    private String content;
    private List<MessageDto> messages;

    @Builder
    public SmsNcpDto(String from, String content, List<MessageDto> messages) {
        this.from = from;
        this.content = content;
        this.messages = messages;
    }
}
