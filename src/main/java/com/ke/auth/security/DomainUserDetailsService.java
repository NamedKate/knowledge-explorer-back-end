package com.ke.auth.security;

import com.ke.auth.model.SysUser;
import com.ke.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DomainUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		SysUser localUser = userRepository.findByUsername(username);
		if (localUser == null)
			throw new UsernameNotFoundException("用户" + username + "不存在！");
		else
			return new org.springframework.security.core.userdetails.User(localUser.getUsername(), localUser.getPassword(), localUser.getAuthorities());
	}
}
