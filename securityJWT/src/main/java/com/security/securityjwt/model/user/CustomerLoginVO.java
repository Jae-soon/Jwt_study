package com.security.securityjwt.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CustomerLoginVO {
    private String username;
    private String password;

    public boolean isNotValid() {
        return username == null
                || password == null
                || username.trim().length() == 0
                || password.trim().length() == 0;
    }
}
