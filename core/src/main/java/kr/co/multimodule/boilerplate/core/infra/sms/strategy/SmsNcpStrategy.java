package kr.co.multimodule.boilerplate.core.infra.sms.strategy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.tools.javac.util.List;
import kr.co.multimodule.boilerplate.core.infra.sms.SmsStrategy;
import kr.co.multimodule.boilerplate.core.infra.sms.dto.MessageDto;
import kr.co.multimodule.boilerplate.core.infra.sms.dto.SmsNcpDto;
import kr.co.multimodule.boilerplate.core.infra.sms.dto.SmsNcpResponseDto;
import kr.co.multimodule.boilerplate.core.infra.sms.enumtype.SmsType;
import kr.co.multimodule.boilerplate.core.infra.sms.util.StringParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import static kr.co.multimodule.boilerplate.core.infra.sms.util.StringParser.makeCertificationNumber;

@Slf4j
@Component
@RequiredArgsConstructor
public class SmsNcpStrategy implements SmsStrategy {
    private final ObjectMapper mapper;

    private final WebClient webClient = WebClient.builder().build();

    @Value("${naver.access-key}")
    private String accessKey;
    @Value("${naver.secret-key}")
    private String secretKey;
    @Value("${naver.service-id}")
    private String serviceId;

    @Value("${naver.phone-number}")
    private String sendPhoneNumber;

    private static final String SMS_BASE_URL = "https://sens.apigw.ntruss.com";
    private static final String DETAIL_URL = "/sms/v2/services/%s/messages";

    private static final String TIMESTAMP_HEADER = "x-ncp-apigw-timestamp";
    private static final String ACCESS_KEY_HEADER = "x-ncp-iam-access-key";
    private static final String SIGNATURE_HEADER = "x-ncp-apigw-signature-v2";


    @Override
    public SmsType getStrategyName() {
        return SmsType.NCP;
    }

    private WebClient.ResponseSpec createRequest(String path, String body) {
        long currentTimestamp = System.currentTimeMillis();
        String signature = StringParser.makeSignature(accessKey, secretKey, currentTimestamp);

        return webClient.post()
                .uri(SMS_BASE_URL + path)
                .headers(httpHeaders -> {
                            httpHeaders.add(TIMESTAMP_HEADER, String.valueOf(currentTimestamp));
                            httpHeaders.add(ACCESS_KEY_HEADER, accessKey);
                            httpHeaders.add(SIGNATURE_HEADER, signature);
                        }
                )
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(body))
                .retrieve();
    }

    @Override
    public void sendCertificationNumber(SmsType smsType, String destPhoneNumber) {
        SmsNcpDto dto = SmsNcpDto.builder()
                .from(sendPhoneNumber)
                .content(String.format("인증번호 [%s] 입니다.", makeCertificationNumber()))
                .messages(List.of(
                        new MessageDto(destPhoneNumber)
                ))
                .build();

        String body = null;
        try {
            body = mapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        SmsNcpResponseDto result = this.createRequest(String.format(DETAIL_URL, serviceId), body)
                .bodyToMono(SmsNcpResponseDto.class).block();

        log.info(result.toString());
    }

    private String getUrl() {
        return String.format(SMS_BASE_URL, serviceId) + String.format(DETAIL_URL, serviceId);
    }
}
