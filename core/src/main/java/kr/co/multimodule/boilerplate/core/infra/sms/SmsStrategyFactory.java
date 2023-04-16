package kr.co.multimodule.boilerplate.core.infra.sms;

import kr.co.multimodule.boilerplate.core.infra.sms.enumtype.SmsType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class SmsStrategyFactory {

    private Map<SmsType, SmsStrategy> strategies;

    public SmsStrategyFactory(Set<SmsStrategy> strategySet) {
        createStrategy(strategySet);
    }

    public SmsStrategy findStrategy(SmsType strategyName) {
        return strategies.get(strategyName);
    }

    private void createStrategy(Set<SmsStrategy> strategySet) {
        strategies = new HashMap<>();
        strategySet.forEach(
                strategy ->strategies.put(strategy.getStrategyName(), strategy));
    }
}
