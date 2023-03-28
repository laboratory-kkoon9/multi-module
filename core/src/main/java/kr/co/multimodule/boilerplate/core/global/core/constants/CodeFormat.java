package kr.co.multimodule.boilerplate.core.global.core.constants;

public class CodeFormat {
    public static int HTTP_OK = 200;                // 정상응답, 정상 컨텐츠
    public static int HTTP_NO_CONTENT = 204;        // 요청은 정상이나, 응답할 내용이 없는 경우
    public static int HTTP_RESET_CONTENT = 205;     // 요청에 따라 정상적으로 처리하였으며, 클라이언트에서 뷰를 초기화해야 함
    public static int HTTP_BAD_REQUEST = 400;           // 필수값 체크 실패 등 잘못된 요청
    public static int HTTP_UNAUTHORIZED = 401;          // 인증 필수이지만, 인증 정보 자체가 없음 (권한없음)
    public static int HTTP_FORBIDDEN = 403;             // 인증 정보는 있으나, 권한 밖의 요청인 경우 (권한없음)
    public static int HTTP_NOT_FOUND = 404;             // 찾을수 없음
    public static int HTTP_INTERNAL_SERVER_ERROR = 500; // 서버 내 오류
}
