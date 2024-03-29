package com.intp.common.response.status;

import com.intp.common.response.BaseErrorCode;
import com.intp.common.response.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),
    _UNSUPPORTED_MEDIA_TYPE(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "COMMON405", "지원하지 않는 미디어 파일입니다."),
    IMAGE_IS_NULL(HttpStatus.BAD_REQUEST, "COMMON406", "이미지 파일은 null이면 안됩니다."),

    // 멤버 관련 에러
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    MEMBER_LOGIN_FAILURE(HttpStatus.BAD_REQUEST, "MEMBER4003", "아이디 혹은 비밀번호를 잘못 입력하였습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),
    LOCATION_ARGUMENT_ERROR(HttpStatus.BAD_REQUEST, "MEMBER4003" , "동네 인증 argument가 잘못되었습니다."),

    MEMBER_SIGNUP_ERROR(HttpStatus.BAD_REQUEST, "SIGNUP4001", "회원가입 유효성 검사 실패"),
    EMAIL_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "SIGNUP4002", "이미 존재하는 이메일입니다."),
    FRIEND_ARGUMENT_ERROR(HttpStatus.BAD_REQUEST, "Friend4001", "친구 생성 유효성 검사 실패"),
    PRESENT_ERROR(HttpStatus.BAD_REQUEST, "Present4001", "선물 추가 실패"),
    EVENT_ERROR(HttpStatus.BAD_REQUEST,"Event4001", "경조사 추가 실패"),
    UPDATE_ERROR(HttpStatus.BAD_REQUEST,"Friend4001", "존재하지 않는 친구입니다."),
    UPDATE_FRIEND_ERROR(HttpStatus.BAD_REQUEST,"Friend4001", "친구 등급 업데이트 유효성 검사 실패"),
    // 일정 관련 에러
    SCHEDULE_POST_ARGUMENT_ERROR(HttpStatus.BAD_REQUEST, "SCHEDULE_POST_4001", "일정 작성 오류, 존재하지 않는 친구입니다."),
    SCHEDULE_MONTHLY_ARGUMENT_ERROR(HttpStatus.BAD_REQUEST, "SCHEDULE_POST_4002", "월별 일정 조회 오류, 요청 연 혹은 월이 잘못되었습니다. 다시 확인해주세요."),
    SCHEDULE_DATE_ARGUMENT_ERROR(HttpStatus.BAD_REQUEST, "SCHEDULE_POST_4003", "일별 일정 조회 오류, 요청 연 혹은 월 혹은 날이 잘못되었습니다. 다시 확인해주세요."),
    SCHEDULE_DELETE_NOT_EXIST_ERROR(HttpStatus.BAD_REQUEST, "SCHEDULE_DELETE_4004", "삭제 중 에러. 삭제 요청한 일정이 존재하지않습니다. 일정의 아이디를 다시 확인해주세요.")

    ;




    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}
