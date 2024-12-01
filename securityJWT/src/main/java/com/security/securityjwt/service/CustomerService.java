package com.security.securityjwt.service;

import com.security.securityjwt.entity.Customer;
import com.security.securityjwt.model.common.ResponseData;
import com.security.securityjwt.model.user.CustomerJoinVO;
import com.security.securityjwt.model.user.CustomerLoginVO;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Customer findByUsername(String username);

    void join(CustomerJoinVO request);

    String login(CustomerLoginVO request);
}
