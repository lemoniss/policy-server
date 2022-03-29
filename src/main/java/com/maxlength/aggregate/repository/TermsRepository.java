package com.maxlength.aggregate.repository;

import com.maxlength.aggregate.entity.TermsEntity;
import com.maxlength.spec.enums.Yesno;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermsRepository extends JpaRepository<TermsEntity, Long> {

    List<TermsEntity> findByViewYnAndDelYnAndServiceEntityNameAndDelYnOrderByRequireYnDescIdAsc(Yesno viewYn, Yesno useYn, String name, Yesno delYn);
}