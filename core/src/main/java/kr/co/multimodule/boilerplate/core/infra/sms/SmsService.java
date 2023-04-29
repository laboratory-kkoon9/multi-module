package kr.co.multimodule.boilerplate.core.infra.sms;

import kr.co.multimodule.boilerplate.core.infra.sms.enumtype.SmsType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static kr.co.multimodule.boilerplate.core.infra.sms.util.StringParser.makeCertificationNumber;

@Slf4j
@RequiredArgsConstructor
@Service
public class SmsService {
    private final SmsStrategyFactory strategyFactory;

    public String sendCertificationNumber(final SmsType smsType, final String destPhoneNumber) {
        final SmsStrategy smsStrategy = this.decideSmsClientStrategy(smsType);
        String certificationNumber = makeCertificationNumber();
        smsStrategy.sendCertificationNumber(destPhoneNumber, certificationNumber);
        return certificationNumber;
    }

    private SmsStrategy decideSmsClientStrategy(final SmsType smsType) {
        return this.strategyFactory.findStrategy(smsType);
    }
}
