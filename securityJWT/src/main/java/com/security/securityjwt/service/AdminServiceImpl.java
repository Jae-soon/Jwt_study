package com.security.securityjwt.service;

import com.security.securityjwt.entity.Customer;
import com.security.securityjwt.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    @Override
    public Customer findByUsername(String username) {
        return adminRepository.findByUsername(username).get();
    }
}
