package com.luo.dianshang.service.impl;

import com.luo.dianshang.entity.User;
import com.luo.dianshang.mapper.UserMapper;
import com.luo.dianshang.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 花折
 * @since 2020-05-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
