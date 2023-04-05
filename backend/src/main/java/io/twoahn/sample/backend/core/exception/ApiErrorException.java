package io.twoahn.sample.backend.core.exception;

import lombok.Builder;
import lombok.Getter;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by rockoil@gmail.com on 23. 4. 5.
 * Blog : http://ioioi.dev
 * Github : http://github.com/ioioi-dev
 */
@Getter
public class ApiErrorException extends RuntimeException {

    protected final String errorCode;

    public ApiErrorException(Throwable e) {
        super(e);
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        super.printStackTrace(pw);
        this.errorCode = "ERR0000";
    }

    @Builder
    public ApiErrorException(String errorCode, String message) {
        super(message);
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        super.printStackTrace(pw);
        this.errorCode = errorCode;
    }
}
