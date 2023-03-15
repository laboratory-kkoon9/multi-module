package kr.co.multimodule.boilerplate.api.controller;

import kr.co.multimodule.boilerplate.core.user.application.port.inport.SignUpCommand;
import kr.co.multimodule.boilerplate.core.user.application.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final SignUpService signUpService;

    @PostMapping("/signup")
    public ResponseEntity<?> getSampleName(@RequestBody SignUpCommand command) {
        System.out.println(command);
        signUpService.signUp(command);
        return ResponseEntity.ok()
                .body("ok");
    }
}
