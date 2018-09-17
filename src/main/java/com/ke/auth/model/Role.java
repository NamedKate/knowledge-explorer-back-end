package com.ke.auth.model;

import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@Data
@NodeEntity
public class Role {

    @Relationship(type = "HAVE")
    Set<Permission> permissionList;

	private String roleName;
	private String code;
    @GraphId
    private Long id;


}
