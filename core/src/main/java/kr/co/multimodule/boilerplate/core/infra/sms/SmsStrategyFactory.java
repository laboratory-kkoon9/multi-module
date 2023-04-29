package kr.co.multimodule.boilerplate.core.infra.sms;

import kr.co.multimodule.boilerplate.core.infra.sms.enumtype.SmsType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class SmsStrategyFactory {
    private static final String SMS_TYPE_NULL_MESSAGE = "smsType은 필수값입니다.";

    private Map<SmsType, SmsStrategy> strategies;

    @Autowired
    public SmsStrategyFactory(Set<SmsStrategy> strategySet) {
        createStrategy(strategySet);
    }

    public SmsStrategy findStrategy(SmsType smsType) {
        Objects.requireNonNull(smsType, SMS_TYPE_NULL_MESSAGE);

        return strategies.get(smsType);
    }

    private void createStrategy(Set<SmsStrategy> strategySet) {
        strategies = new HashMap<>();
        strategySet.forEach(
                strategy ->strategies.put(strategy.getStrategyName(), strategy));
    }
}
