package io.twoahn.sample.backend.core.exception;

import io.twoahn.sample.backend.core.dto.CmmDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by rockoil@gmail.com on 23. 4. 5.
 * Blog : http://ioioi.dev
 * Github : http://github.com/ioioi-dev
 */
@Slf4j
@RestControllerAdvice
public class ApiRestControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiErrorException.class)
    protected ResponseEntity<CmmDto.Res<Object>> handleApiErrorException(ApiErrorException e) {

        CmmDto.Res<Object> res = CmmDto.Res.builder()
                .code(e.getErrorCode())
                .message(e.getMessage())
                .build();

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
