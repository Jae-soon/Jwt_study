package com.security.securityjwt.service;

import com.security.securityjwt.entity.Customer;
import com.security.securityjwt.global.util.JwtUtil;
import com.security.securityjwt.model.user.CustomerJoinVO;
import com.security.securityjwt.model.user.CustomerLoginVO;
import com.security.securityjwt.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username).get();
    }

    @Override
    public void join(CustomerJoinVO request) {
        Customer customer = Customer.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .name(request.getName())
                .role(request.getRole())
                .build();

        customerRepository.save(customer);
    }

    @Override
    public String login(CustomerLoginVO request) {
        final String token;
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );

            Customer customer = customerRepository.findByUsername(request.getUsername()).get();

            token = jwtUtil.generateToken(customer.getUsername(), customer.getRole().name());
        } catch (Exception e) {
            return "Invalid Username or Password!!!";
        }

        return token;
    }
}
