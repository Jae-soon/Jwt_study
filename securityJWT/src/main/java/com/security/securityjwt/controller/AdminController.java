package com.security.securityjwt.controller;

import com.security.securityjwt.global.util.ResponseUtil;
import com.security.securityjwt.model.common.ResponseData;
import com.security.securityjwt.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/info")
    public ResponseEntity<ResponseData> retrieveAdminInfo(@AuthenticationPrincipal UserDetails customer) {
        return ResponseUtil.successResponse(adminService.findByUsername(customer.getUsername()));
    }
}
