package com.ke.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@NodeEntity(label = "User")
public class SysUser {

    @GraphId
	private Long id;

	private String username;
	@JsonIgnore
	private String password;
	private Byte sex;
	private String intro;
	private String phone;
	private String email;
	private String nickname;

	@Relationship(type = "HAVE")
    private Set<Role> roleList;

	public Set<GrantedAuthority> getAuthorities(){
		return roleList.stream().map(role -> new SimpleGrantedAuthority(role.getRolename())).collect(Collectors.toSet());
	}

	public SysUser(){}

}
