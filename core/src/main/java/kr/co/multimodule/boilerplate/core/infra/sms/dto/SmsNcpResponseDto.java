package kr.co.multimodule.boilerplate.core.infra.sms.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class SmsNcpResponseDto {
    private String requestId;
    private String requestTime;
    private String statusCode;
    private String statusName;
}
