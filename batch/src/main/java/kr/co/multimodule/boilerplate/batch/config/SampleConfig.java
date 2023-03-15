package kr.co.multimodule.boilerplate.batch.config;

import kr.co.multimodule.boilerplate.core.sample.SampleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleConfig {

    @Bean
    public SampleService sampleService() {
        return new SampleService();
    }
}
