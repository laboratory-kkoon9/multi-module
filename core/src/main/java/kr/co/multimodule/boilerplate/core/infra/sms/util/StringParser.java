package kr.co.multimodule.boilerplate.core.infra.sms.util;

import kr.co.multimodule.boilerplate.core.global.core.exception.SignatureException;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.util.concurrent.ThreadLocalRandom;

import static kr.co.multimodule.boilerplate.core.global.core.constants.CodeFormat.HTTP_BAD_REQUEST;

public class StringParser {
    private static final String SIGNATURE_ERROR_MESSAGE = "암호화 도중 에러가 발생했습니다.";
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";
    private static final String METHOD = "GET";
    private static final String URL = "/photos/puppy.jpg?query1=&query2";

    private StringParser() {

    }

    public static String makeSignature(String accessKey, String secretKey, long currentTimestamp) {
        String message = new StringBuilder()
                .append(METHOD)
                .append(SPACE)
                .append(URL)
                .append(NEW_LINE)
                .append(currentTimestamp)
                .append(NEW_LINE)
                .append(accessKey)
                .toString();

        String encodeBase64String = null;

        try {
            SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);

            byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
            encodeBase64String = Base64.encodeBase64String(rawHmac);
        } catch (Exception e) {
            throw new SignatureException(SIGNATURE_ERROR_MESSAGE, HTTP_BAD_REQUEST);
        }

        return encodeBase64String;
    }

    public static String makeCertificationNumber() {
        int number = ThreadLocalRandom.current().nextInt(100000, 1000000);
        return String.valueOf(number);
    }
}
