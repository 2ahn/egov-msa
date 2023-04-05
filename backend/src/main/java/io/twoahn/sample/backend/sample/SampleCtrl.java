package io.twoahn.sample.backend.sample;

import io.twoahn.sample.backend.core.ctrl.CmmCtrl;
import io.twoahn.sample.backend.core.dto.CmmDto;
import io.twoahn.sample.backend.core.exception.ApiErrorException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rockoil@gmail.com on 23. 4. 5.
 * Blog : http://ioioi.dev
 * Github : http://github.com/ioioi-dev
 */
@Slf4j
@RestController
@RequestMapping(value = "/sample")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SampleCtrl extends CmmCtrl {

    @PostMapping(value = "/index1")
    public CmmDto.Res<?> index1(@RequestBody CmmDto.Req<Map<String, Object>> param) {

        Map<String, Object> ret = new HashMap<>();

        try {

            Map<String, Object> paramValue = param.getData();

            ret.put("result", paramValue.get("result"));

        } catch (Throwable e) {
            throw new ApiErrorException(e);
        } finally {
            ret = (Map<String, Object>) isNil.apply(ret, new HashMap<>());
        }

        return new CmmDto.Res<>(ret);
    }

    @PostMapping(value = "/index2")
    public CmmDto.Res<?> index2(@RequestBody Map<String, Object> param) {

        Map<String, Object> ret = new HashMap<>();

        try {

            ret.put("result", "ok");

            throw new RuntimeException("어떤사유로 오류 발생");

        } catch (Throwable e) {
            throw new ApiErrorException(e);
        } finally {
            ret = (Map<String, Object>) isNil.apply(ret, new HashMap<>());
        }

        //return new CmmDto.Res<>(ret);
    }
}
