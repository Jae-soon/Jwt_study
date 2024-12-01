package com.security.securityjwt.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class CustomerJoinVO {
    private String username;
    private String password;
    private String name;
    private String email;
    private UserRole role;
}
