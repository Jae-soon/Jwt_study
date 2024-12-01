package com.security.securityjwt.model.user;

import com.security.securityjwt.entity.Customer;
import java.util.List;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Getter
public class CustomerContext extends User {
    private String username;
    private String name;
    private String email;
    private String userRole;

    public CustomerContext(Customer customer, List<GrantedAuthority> authorities) {
        super(customer.getUsername(), customer.getPassword(), authorities);
        this.username = customer.getUsername();
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.userRole = String.valueOf(customer.getRole());
    }
}
