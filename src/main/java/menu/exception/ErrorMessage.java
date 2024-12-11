package menu.exception;

public enum ErrorMessage {

    ERROR_SIGNATURE("[ERROR] "),
    MIN_COACH_SIZE("코치는 최소 2명 이상 입력해야 합니다."),
    MAX_COACH_SIZE("코치는 최대 5명 입력 가능 합니다."),
    DUPLICATE_COACH("중복된 코치를 입력할 수 없습니다."),
    DELIMITER_NON("콤마로 구분해야 합니다."),
    NAME_SIZE("코치 이름은 최소 2글자 이상 4글자 미만으로 해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return ERROR_SIGNATURE.message + this.message;
    }
}