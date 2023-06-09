package com.umc.umcspring.response;

public class ResponseMessage {
    public static final String INTERNAL_SERVER_ERROR = "서버 내부 에러";
    public static final String DB_ERROR = "데이터베이스 에러";

    public static final String SUCCESS_REGISTER_MEMBER = "회원가입 성공";
    public static final String SUCCESS_CHECK_MEMBER_INFO = "회원 정보 조회 성공";
    public static final String SUCCESS_LOGIN_MEMBER = "회원 로그인 성공";
    public static final String FAIL_LOGIN_MEMBER = "회원 로그인 실패";
    public static final String SUCCESS_UPDATE_MEMBER_INFO = "회원 정보 수정 성공";
    public static final String FAIL_UPDATE_MEMBER_INFO = "회원 정보 수정 실패(일치하는 회원 정보 없음)";
    public static final String SUCCESS_DELETE_MEMBER_INFO = "회원 정보 삭제 성공";
    public static final String FAIL_DELETE_MEMBER_INFO = "회원 정보 삭제 실패";

    public static final String SUCCESS_REGISTER_POST = "글 등록 성공";
    public static final String SUCCESS_CHECK_POST_INFO = "글 상세 조회 성공";
    public static final String SUCCESS_UPDATE_POST_DETAIL = "글 수정 성공";
    public static final String FAIL_UPDATE_POST_DETAIL = "글 수정 실패(일치하는 글 없음)";
    public static final String SUCCESS_UPDATE_POST_TITLE = "글 제목 수정 성공";
    public static final String FAIL_UPDATE_POST_TITLE = "글 제목 수정 실패";
    public static final String SUCCESS_DELETE_POST = "글 삭제 성공";
    public static final String FAIL_DELETE_POST = "글 삭제 실패";

    public static final String FAIL_WRONG_MEMBER = "실패 (잘못된 사용자)";
}
