package kr.co.multimodule.boilerplate.core.infra.sms;

import kr.co.multimodule.boilerplate.core.infra.sms.enumtype.SmsType;

public interface SmsStrategy {
    SmsType getStrategyName();
    void sendCertificationNumber(SmsType smsType, String destPhoneNumber);
}
