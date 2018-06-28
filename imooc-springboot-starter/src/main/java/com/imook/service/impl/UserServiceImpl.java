package com.imook.service.impl;

import com.imook.mapper.SysUserMapper;
import com.imook.pojo.SysUser;
import com.imook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    /**
     *这里是红色的，是因为缺少一个Mybatis Plugin的插件支持。
     * Autowired代表是注入操作
     */
    @Autowired
    private SysUserMapper userMapper;

    @Override
    public void saveUser(SysUser user) throws Exception {
        userMapper.insert(user);
    }

    @Override
    public void updateUser(SysUser user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void deleteUser(SysUser user) {
        userMapper.delete(user);
    }

    @Override
    public SysUser queryUserById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<SysUser> queryUserList(SysUser user) {
        return userMapper.select(user);
    }
}
