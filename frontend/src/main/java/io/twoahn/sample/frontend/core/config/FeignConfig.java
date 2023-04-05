package io.twoahn.sample.frontend.core.config;

import feign.codec.Decoder;
import io.twoahn.sample.frontend.core.feign.FeignDecoder;
import org.springframework.context.annotation.Bean;

/**
 * Created by rockoil@gmail.com on 23. 4. 5.
 * Blog : http://ioioi.dev
 * Github : http://github.com/ioioi-dev
 */
public class FeignConfig {

    @Bean
    Decoder fiegnDecoder() {
        return new FeignDecoder();
    }
}
