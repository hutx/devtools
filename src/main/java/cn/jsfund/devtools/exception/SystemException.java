package cn.jsfund.devtools.exception;

/**
 * Created by hutx on 19:00 2018/11/21
 */
public class SystemException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private ErrorCode errorCode;

    public SystemException(String message) {
        this(message, ErrorCode.SERVER_ERROR);
    }

    public SystemException(String message, Throwable cause) {
        this(message, cause, ErrorCode.SERVER_ERROR);
    }

    public SystemException(String message, ErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public SystemException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public SystemException setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
        return this;
    }
}
