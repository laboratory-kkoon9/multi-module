package kr.co.multimodule.boilerplate.core.sample;

import org.springframework.stereotype.Service;

@Service
public class SampleService {

    public String getSampleName(String name) {
        return name + "-sample";
    }
}
