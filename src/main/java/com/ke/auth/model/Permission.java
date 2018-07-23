package com.ke.auth.model;

import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NodeEntity
public class Permission {

    @GraphId
	private Long id;

	private String permissionname;
	private String code;
}
