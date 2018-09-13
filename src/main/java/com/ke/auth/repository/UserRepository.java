package com.ke.auth.repository;

import com.ke.auth.model.SysUser;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends Neo4jRepository<SysUser, Long> {

    SysUser findByUsername(String username);

    SysUser findById(Long id);

    List<SysUser> findAll();

}
