package io.twoahn.sample.backend.sample.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Schema(description = "샘플 VO")
public class SampleVO {

    @Schema(description = "샘플텍스트")
    private String sampleText;

    @Schema(description = "샘플텍스트2")
    private String sampleText2;

    @Builder
    public SampleVO(String sampleText, String sampleText2) {
        this.sampleText = sampleText;
        this.sampleText2 = sampleText2;
    }
}
