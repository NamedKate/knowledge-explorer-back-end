package com.ke.auth.controller;

import com.ke.auth.model.SysUser;
import com.ke.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

import static com.ke.auth.util.PageConst.PAGE_SIZE;

@RestController
public class UserController {

	@Autowired
    private UserService userService;

	// vanilla
	@GetMapping("/user")
	public Principal user(Principal user) throws Exception {
		return user;
	}

	// get user information
    @GetMapping("/user_info/{username}")
    public SysUser getUserInfoByUsername(@PathVariable String username) throws Exception {
	    return userService.getUser(username);
    }

    @GetMapping("/user_info/{id}")
    public SysUser getUserInfoByid(@PathVariable Long id) throws Exception {
	    return userService.getUser(id);
    }

    @GetMapping("/user_info/{page}")
    public Page<SysUser> getUserByPage(@PathVariable Integer page) throws Exception {
	    return userService.getUserByPage(new PageRequest(page - 1, PAGE_SIZE));
    }

    @GetMapping("/user_info")
    public List<SysUser> getUserList() throws Exception {
	    return userService.getUserList();
    }

    @PostMapping("/user_info")
    public SysUser addUser(@RequestBody SysUser sysUser) throws Exception {
	    return userService.addUser(sysUser);
    }

    @DeleteMapping("/user_info")
    public boolean deleteUser(@RequestBody SysUser sysUser) throws Exception {
	    return userService.deleteUser(sysUser);
    }

//    @GetMapping("/assign_role/{username}/{rolecode}")
//    public boolean
}
