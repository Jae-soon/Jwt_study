package com.security.securityjwt.service;

import com.security.securityjwt.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    Customer findByUsername(String username);
}
