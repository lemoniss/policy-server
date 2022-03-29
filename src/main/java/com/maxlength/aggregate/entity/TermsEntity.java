package com.maxlength.aggregate.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.maxlength.spec.enums.Yesno;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Table(name = "terms_mst")
public class TermsEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name= "name", length = 50)   // 약관명
    private String name;

    @Column(name= "contents", columnDefinition = "text")   // 약관내용
    private String contents;

    @Column(name= "ver", length = 10)   // 약관버전
    private String ver;

    @Column(name= "del_yn", length = 1, columnDefinition = "char")
    @Enumerated(EnumType.STRING)
    private Yesno delYn;

    @Column(name= "view_yn", length = 1, columnDefinition = "char")
    @Enumerated(EnumType.STRING)
    private Yesno viewYn;

    @Column(name= "group_id", length = 50)   // 약관그룹
    private String groupId;

    @Column(name= "require_yn", length = 1, columnDefinition = "char")
    @Enumerated(EnumType.STRING)
    private Yesno requireYn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "service_id")
    private ServiceEntity serviceEntity;

}