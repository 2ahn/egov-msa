package io.twoahn.sample.frontend.core.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by rockoil@gmail.com on 23. 4. 5.
 * Blog : http://ioioi.dev
 * Github : http://github.com/ioioi-dev
 */
public class CmmDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Req<T> {

        private String token;

        private T data;

        @Builder
        public Req(String token, T data) {
            this.token = token;
            this.data = data;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Res<T> {

        private String code;

        private String message;

        private T data;

        @Builder
        public Res(String code, String message, T data) {
            this.code = code;
            this.message = message;
            this.data = data;
        }
    }
 }
