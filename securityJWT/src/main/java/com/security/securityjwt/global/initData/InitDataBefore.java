package com.security.securityjwt.global.initData;


import com.security.securityjwt.model.user.CustomerJoinVO;
import com.security.securityjwt.model.user.UserRole;
import com.security.securityjwt.service.CustomerService;

public interface InitDataBefore {
    default void before(CustomerService customerService) {
        CustomerJoinVO joinForm1 = new CustomerJoinVO("user1", "1234", "권재순", "qwerasf@naver.com", UserRole.ADMIN);
        CustomerJoinVO joinForm2 = new CustomerJoinVO("user2", "1234", "정지영", "qwerqwer@naver.com", UserRole.USER);
        customerService.join(joinForm1);
        customerService.join(joinForm2);
    }
}
