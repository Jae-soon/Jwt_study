package com.security.securityjwt.entity;

import com.security.securityjwt.model.user.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@SuperBuilder
public class Customer extends BaseEntity {
    private String username;
    private String password;
    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}
