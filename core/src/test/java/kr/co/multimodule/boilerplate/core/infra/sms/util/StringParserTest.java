package kr.co.multimodule.boilerplate.core.infra.sms.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static kr.co.multimodule.boilerplate.core.infra.sms.util.StringParser.makeCertificationNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class StringParserTest {

    @Test
    @DisplayName("6자리 인증번호를 리턴한다.")
    void makeCertificationNumber_test1() {
        // when
        String result = makeCertificationNumber();
        Integer number = Integer.valueOf(result);

        // then
        assertAll(
                () -> assertThat(number).isGreaterThan(100000),
                () -> assertThat(number).isLessThan(1000000)
        );
    }
}
