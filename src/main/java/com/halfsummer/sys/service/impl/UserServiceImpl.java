package com.halfsummer.sys.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.halfsummer.sys.entity.User;
import com.halfsummer.sys.mapper.UserMapper;
import com.halfsummer.sys.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author halfsummer
 * @since 2020-06-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
