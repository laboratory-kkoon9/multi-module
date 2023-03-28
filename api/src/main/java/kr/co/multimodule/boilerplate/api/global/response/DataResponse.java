package kr.co.multimodule.boilerplate.api.global.response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import kr.co.multimodule.boilerplate.core.global.core.constants.CodeFormat;
import lombok.Getter;

@Getter
public class DataResponse<T> {

    public int statusCode;
    public String requestTime = getDateToStringFormat(LocalDateTime.now());
    public T data;

    public DataResponse() {
        this.statusCode = CodeFormat.HTTP_OK;
    }

    public DataResponse(T data) {
        this.statusCode = CodeFormat.HTTP_OK;
        this.data = data;
    }

    public DataResponse(int statusCode, T data) {
        this.statusCode = statusCode;
        this.data = data;
    }

    private static String getDateToStringFormat(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
