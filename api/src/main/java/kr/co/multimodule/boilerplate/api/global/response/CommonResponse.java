package kr.co.multimodule.boilerplate.api.global.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CommonResponse<T> {

    public int code;
    public String message;
    public T response;

    public CommonResponse(T response) {
        this.message = "success";
        this.response = response;
    }

    public CommonResponse(int code, String message, T response) {
        this.code = code;
        this.message = message;
        this.response = response;
    }

    @JsonCreator
    public CommonResponse(@JsonProperty("code") int code,
                          @JsonProperty("message") String message) {
        this.code = code;
        this.message = message;
    }
}
