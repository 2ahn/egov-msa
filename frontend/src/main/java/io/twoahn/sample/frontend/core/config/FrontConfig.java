package io.twoahn.sample.frontend.core.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by rockoil@gmail.com on 23. 4. 5.
 * Blog : http://ioioi.dev
 * Github : http://github.com/ioioi-dev
 */
@Configuration
public class FrontConfig {

    @Bean
    public Contract useFeignAnnotations() {
        return new Contract.Default();
    }
}
