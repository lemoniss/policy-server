package com.maxlength.spec.vo;

import com.maxlength.spec.enums.Yesno;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;

@ApiModel(description = "약관 VO")
public class Terms {

    @Getter
    @Builder
    @ApiModel(description = "약관정보 VO")
    public static class TermsInfo {

        private List<TermsDetail> termsInfoRequired;
        private List<TermsDetail> termsInfoOptional;
    }

    @Getter
    @Builder
    @ApiModel(description = "약관정보 Detail VO")
    public static class TermsDetail {

        @ApiModelProperty(notes = "약관식별자", example = "1")
        private Long id;

        @ApiModelProperty(notes = "약관제목", example = "개인정보이용동의")
        private String name;

        @ApiModelProperty(notes = "약관내용", example = "1조1항 개인정보동의 ........")
        private String contents;

        @ApiModelProperty(notes = "약관버전", example = "0.1")
        private String ver;

        @ApiModelProperty(notes = "필수여부", example = "Y")
        @Enumerated(EnumType.STRING)
        private Yesno require;

        @ApiModelProperty(notes = "약관그룹", example = "A")
        private String groupId;
    }
}
