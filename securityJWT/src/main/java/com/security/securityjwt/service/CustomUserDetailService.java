package com.security.securityjwt.service;

import com.security.securityjwt.entity.Customer;
import com.security.securityjwt.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final CustomerRepository customerRepository;

    @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found!"));

        // 조회한 Customer 객체와 권한과 함께 CustomerContext에 저장
        return User.builder()
                .username(customer.getUsername())
                .password(customer.getPassword())
                .authorities(Collections.singletonList(new SimpleGrantedAuthority(customer.getRole().name())))
                .build();
    }
}
