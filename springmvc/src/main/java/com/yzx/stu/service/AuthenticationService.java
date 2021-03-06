package com.yzx.stu.service;

import com.yzx.stu.model.AuthenticationRequest;
import com.yzx.stu.model.UserDto;

public interface AuthenticationService {
    /**
     * 用户认证
     * @param authenticationRequest 用户认证请求
     * @return 认证成功的用户信息
     */
    UserDto authentication(AuthenticationRequest authenticationRequest);
}
