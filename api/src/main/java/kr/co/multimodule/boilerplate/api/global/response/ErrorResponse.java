package kr.co.multimodule.boilerplate.api.global.response;

import lombok.Getter;

@Getter
public class ErrorResponse {

    public int code;
    public String message;

    public ErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
