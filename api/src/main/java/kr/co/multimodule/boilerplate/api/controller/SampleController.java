package kr.co.multimodule.boilerplate.api.controller;

import kr.co.multimodule.boilerplate.core.sample.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SampleController {
    private final SampleService sampleService;

    @GetMapping("/sample/{name}")
    public ResponseEntity<String> getSampleName(@PathVariable("name") String name) {
        return ResponseEntity.ok()
                .body(sampleService.getSampleName(name));
    }
}
