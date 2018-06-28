package com.imook.service;

import com.imook.pojo.SysUser;

import java.util.List;

public interface UserService {
    public void saveUser(SysUser user) throws Exception;
    public void updateUser(SysUser user);
    public void deleteUser(SysUser user);
    public SysUser queryUserById(String userId);
    public List<SysUser> queryUserList(SysUser user);
}
