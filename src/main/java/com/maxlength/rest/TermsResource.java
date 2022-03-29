package com.maxlength.rest;

import com.maxlength.aggregate.service.TermsService;
import com.maxlength.spec.common.BaseResponse;
import com.maxlength.spec.vo.Terms.TermsInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/terms")
@Api(tags= {"[정책] - 이용약관 API"}, protocols="http", produces="application/json", consumes="application/json")
public class TermsResource {

    private final TermsService termsService;

    public TermsResource(TermsService termsService) {
        this.termsService = termsService;
    }


    @GetMapping
    @ApiOperation(value = "약관 리스트", notes = "약관 리스트")
    public ResponseEntity<TermsInfo> termsList(
            @ApiParam(value="서비스명", defaultValue = "I") @RequestParam String name) {
        return BaseResponse.ok(termsService.termsList(name));
    }

}
