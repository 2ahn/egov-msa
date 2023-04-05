package io.twoahn.sample.frontend.core.cmm;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.twoahn.sample.frontend.core.config.FeignConfig;
import io.twoahn.sample.frontend.core.dto.CmmDto;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by rockoil@gmail.com on 23. 4. 5.
 * Blog : http://ioioi.dev
 * Github : http://github.com/ioioi-dev
 */

@FeignClient(name="feign-client", url="http://localhost:8888", configuration = FeignConfig.class)
public interface BaseFeign {

    @RequestLine("POST {url}")
    @Headers({
            "Content-Type: application/json",
            "Authorization: Bearer {token}"
    })
    @Body("%7B\"data\" : {data} %7D")
    CmmDto.Res<?> postTransferData(@Param("url") final String url, @Param("token")final String token, @Param("data")final String data);
}
