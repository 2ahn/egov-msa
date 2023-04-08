package io.twoahn.sample.backend.sample;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.twoahn.sample.backend.core.ctrl.CmmCtrl;
import io.twoahn.sample.backend.core.dto.CmmDto;
import io.twoahn.sample.backend.core.exception.ApiErrorException;
import io.twoahn.sample.backend.sample.vo.SampleVO;
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
@Tag(name="샘플", description = "샘플 컨트롤러 정보")
@Slf4j
@RestController
@RequestMapping(value = "/sample")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SampleCtrl extends CmmCtrl {

    @Operation(summary = "공통코드 목록 페이징", description = "공통코드 목록 페이징을 조회한다.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "응답정보입니다.",
                            content = @Content(
                                    mediaType = "application/json",
                                    schemaProperties = {
                                            @SchemaProperty(
                                                    name = "code",
                                                    schema = @Schema(type = "string", name = "code", description = "응답코드")
                                            ),
                                            @SchemaProperty(
                                                    name = "msg",
                                                    schema = @Schema(type = "string", name = "msg", description = "응답메세지")
                                            ),
                                            @SchemaProperty(
                                                    name = "data",
                                                    schema = @Schema(implementation = SampleVO.class, description = "응답페지정보")

                                            )
                                    }
                            )
                    )
            }
    )
    @PostMapping(value = "/index1")
    public CmmDto.Res<?> index1(@RequestBody
                                    @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                            content = @Content(
                                                    mediaType = "application/json",
                                                    schema = @Schema(
                                                            type = "object",
                                                            description = "요청객체"
                                                    ),
                                                    schemaProperties = @SchemaProperty(
                                                            name = "data",
                                                            schema = @Schema(implementation = SampleVO.class)
                                                    )
                                            )
                                    )
                                    CmmDto.Req<SampleVO> param) {

        Map<String, Object> ret = new HashMap<>();

        try {

            SampleVO result = param.getData();

            ret.put("result", result.getSampleText());

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
