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

    public SysUser addUser(SysUser sysUser){
        return userRepository.save(sysUser);
    }

    public boolean deleteUser(SysUser sysUser){
        boolean status = false;
        try{
            userRepository.delete(sysUser);
            status = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public List<SysUser> getUserList(){
        return userRepository.findAll();
    }

    public SysUser getUser(Long id){
        return userRepository.findById(id);
    }

    public Page<SysUser> getUserByPage(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    public SysUser getUser(String username){
        return userRepository.findByUsername(username);
    }
}
