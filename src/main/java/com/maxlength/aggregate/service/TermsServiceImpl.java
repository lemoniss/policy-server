package com.maxlength.aggregate.service;

import com.maxlength.aggregate.entity.TermsEntity;
import com.maxlength.aggregate.repository.TermsRepository;
import com.maxlength.spec.enums.Yesno;
import com.maxlength.spec.vo.Terms;
import com.maxlength.spec.vo.Terms.TermsInfo;
import com.maxlength.spec.vo.Terms.TermsDetail;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TermsServiceImpl implements TermsService {

    private final TermsRepository repository;

    public TermsServiceImpl(TermsRepository repository) {
        this.repository = repository;
    }

    @Override
    public TermsInfo termsList(String name) {

        List<TermsDetail> termsInfoRequired = new ArrayList<>();
        List<TermsDetail> termsInfoOptional = new ArrayList<>();

        List<TermsEntity> termsEntityList = repository.findByViewYnAndDelYnAndServiceEntityNameAndDelYnOrderByRequireYnDescIdAsc(Yesno.Y, Yesno.N, name, Yesno.N);

        for(TermsEntity termsEntity: termsEntityList) {

            if(termsEntity.getRequireYn().equals(Yesno.Y)) {
                termsInfoRequired.add(Terms.TermsDetail.builder()
                    .id(termsEntity.getId())
                    .name(termsEntity.getName())
                    .contents(termsEntity.getContents())
                    .ver(termsEntity.getVer())
                    .require(termsEntity.getRequireYn())
                    .groupId(termsEntity.getGroupId())
                    .build());
            } else {
                termsInfoOptional.add(Terms.TermsDetail.builder()
                    .id(termsEntity.getId())
                    .name(termsEntity.getName())
                    .contents(termsEntity.getContents())
                    .ver(termsEntity.getVer())
                    .require(termsEntity.getRequireYn())
                    .groupId(termsEntity.getGroupId())
                    .build());
            }
        }

        return TermsInfo.builder()
            .termsInfoRequired(termsInfoRequired)
            .termsInfoOptional(termsInfoOptional)
            .build();
    }

}

