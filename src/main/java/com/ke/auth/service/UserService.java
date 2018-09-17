package com.ke.auth.service;

import com.ke.auth.model.SysUser;
import com.ke.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jueryuer
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public SysUser addUser(SysUser sysUser) throws Exception {
        return userRepository.save(sysUser);
    }

    public boolean deleteUser(SysUser sysUser) throws Exception {
        boolean status = false;
        try{
            userRepository.delete(sysUser);
            status = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public List<SysUser> getUserList() throws Exception {
        return userRepository.findAll();
    }

    public SysUser getUser(Long id) throws Exception {
        return userRepository.findById(id);
    }

    public Page<SysUser> getUserByPage(Pageable pageable) throws Exception {
        return userRepository.findAll(pageable);
    }

    public SysUser getUser(String username) throws Exception {
        return userRepository.findByUsername(username);
    }

//    public QueryResultModel assignUserRole(String username, String roleName){
//
//    }
//
//    public QueryResultModel assignRolePermission(String roleName, String permissionName){
//
//    }
//
//    public QueryResultModel detachUserRole(String username, String roleName){
//
//    }
//
//    public QueryResultModel detachRolePermission(String roleName, String permissionName){
//
//    }
}
