package com.security.securityjwt.entity;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor(access = PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@ToString
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDateTime createdDatetime;

    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDateTime updatedDatetime;

    public BaseEntity(long id) {
        this.id = id;
    }

    @Transient @Builder.Default private Map<String, Object> extra = new LinkedHashMap<>();
}
