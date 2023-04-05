package io.twoahn.sample.frontend.sample;

import io.twoahn.sample.frontend.core.cmm.BaseFeign;
import io.twoahn.sample.frontend.core.ctrl.CmmCtrl;
import io.twoahn.sample.frontend.core.dto.CmmDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * Created by rockoil@gmail.com on 23. 4. 5.
 * Blog : http://ioioi.dev
 * Github : http://github.com/ioioi-dev
 */
@Slf4j
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SampleCtrl extends CmmCtrl {

    private final BaseFeign feign;

    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }

    @PostMapping(value = "/addData")
    @ResponseBody
    public CmmDto.Res<?> addData(@RequestBody final CmmDto.Req<String> param) {

        CmmDto.Res<?> res = CmmDto.Res.builder().build();

        try {

            if(!Objects.isNull(param)) {
                if(StringUtils.hasText(param.getData())) {
                    res = feign.postTransferData("/sample/index1", param.getToken(), param.getData());
                }
            }

        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            res = (CmmDto.Res<?>) isNil.apply(res, CmmDto.Res.builder().build());
        }

        return res;
    }
}
