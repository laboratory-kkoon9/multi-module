package kr.co.multimodule.boilerplate.core.infra.sms;

import kr.co.multimodule.boilerplate.core.infra.sms.enumtype.SmsType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class SmsService {
    private final SmsStrategyFactory strategyFactory;

    private void sendCertificationNumber(SmsType smsType, String destPhoneNumber) {
        SmsStrategy smsStrategy = this.decideSmsClientStrategy(smsType);
        smsStrategy.sendCertificationNumber(smsType, destPhoneNumber);
    }

    private SmsStrategy decideSmsClientStrategy(SmsType smsType) {
        return this.strategyFactory.findStrategy(smsType);
    }
}
