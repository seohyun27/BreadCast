package com.breadcrumbs.breadcast.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)  // 날짜를 자동으로 저장하는 Auditing 기능 활성화
public class BakeryReport {

    @Id
    @GeneratedValue
    @Column(name = "bakery_report_id")
    private long id;

    @Column(name = "report_text")
    private String text;

    @CreatedDate   // 엔티티가 처음 저장될 때 자동으로 값을 삽입
    @Column(name = "report_date")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "bakery_id")
    private Bakery bakery;
}
