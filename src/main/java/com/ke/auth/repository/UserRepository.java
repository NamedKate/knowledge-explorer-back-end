package com.ke.auth.repository;

import com.ke.auth.model.SysUser;
import org.neo4j.ogm.response.model.QueryResultModel;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends Neo4jRepository<SysUser, Long> {

    SysUser findByUsername(String username);

    SysUser findById(Long id) throws Exception;

    List<SysUser> findAll();

    @Query("MATCH (u:User)-[rel1:HAVE]->(r:Role)-[rel2:HAVE]->(p:Permission) WHERE u.username = {username} RETURN u, r, p;")
    QueryResultModel findUserRolePermission(String username);

    @Query("MATCH (u:User), (r:Role) WHERE u.username = {username} AND r.roleName = {roleName} CREATE (u)-[relation:HAVE]->(r) RETURN u, r;")
    void assignUserRole(String username, String roleName);

    @Query("MATCH (r:Role), (p:Permission) WHERE r.roleName = {roleName} AND p.permissionName = {permissionName} CREATE (r)-[relation:HAVE]->(p) RETURN r, p;")
    void assignRolePermission(String roleName, String permissionName);

    @Query("MATCH (u:User)-[relation:HAVE]->(r:Role) WHERE u.username = {username} AND r.roleName = {roleName} DELETE relation;")
    void detachUserRole(String username, String roleName);

    @Query("MATCH (r:Role)-[relation:HAVE]->(p:Permission) WHERE r.roleName = {roleName} AND p.permissionName = {permissionName} DELETE relation;")
    void detachRolePermission(String roleName, String permissionName);

}
