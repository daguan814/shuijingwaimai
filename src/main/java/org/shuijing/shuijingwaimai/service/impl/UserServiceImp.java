package org.shuijing.shuijingwaimai.service.impl;

import org.shuijing.shuijingwaimai.pojo.User;
import org.shuijing.shuijingwaimai.dao.UserDao;
import org.shuijing.shuijingwaimai.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2022-07-20
 */
@Service
public class UserServiceImp extends ServiceImpl<UserDao, User> implements UserService {

}
