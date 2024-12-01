package com.security.securityjwt.controller;

import com.security.securityjwt.entity.Customer;
import com.security.securityjwt.global.util.ResponseUtil;
import com.security.securityjwt.model.common.ResponseData;
import com.security.securityjwt.model.user.CustomerLoginVO;
import com.security.securityjwt.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/v1/user")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/login")
    public ResponseEntity<ResponseData> login(@RequestBody CustomerLoginVO loginRequest) {
        return ResponseUtil.successResponse(customerService.login(loginRequest));
    }
}
