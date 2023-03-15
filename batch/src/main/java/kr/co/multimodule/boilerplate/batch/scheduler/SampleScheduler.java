package kr.co.multimodule.boilerplate.batch.scheduler;

import kr.co.multimodule.boilerplate.core.sample.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SampleScheduler {
    private final SampleService sampleService;

    @Scheduled(fixedDelay = 5000L)
    public void getSampleName() {
        System.out.println("sample name is " + sampleService.getSampleName("batch"));
    }
}
