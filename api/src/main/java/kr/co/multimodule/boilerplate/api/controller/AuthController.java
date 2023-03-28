package kr.co.multimodule.boilerplate.api.controller;

import javax.validation.Valid;
import kr.co.multimodule.boilerplate.api.global.response.CommonResponse;
import kr.co.multimodule.boilerplate.api.global.response.DataResponse;
import kr.co.multimodule.boilerplate.core.user.application.port.inport.SignUpCommand;
import kr.co.multimodule.boilerplate.core.user.application.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final SignUpService signUpService;

    @PostMapping("/signup")
    public ResponseEntity<?> getSampleName(@Valid @RequestBody SignUpCommand command) {
        signUpService.signUp(command);
        return ResponseEntity.ok().body(new CommonResponse<>(new DataResponse()));
    }
}
