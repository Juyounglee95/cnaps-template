package com.skcc.cnaps.role.context.domain.permission.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.skcc.cnaps.shared.share.base.domain.AbstractEntity;
import com.skcc.cnaps.shared.share.base.domain.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Permission extends AbstractEntity implements AggregateRoot{
	
	@Enumerated(EnumType.STRING)
	private PermissionLevel perLevelType;
	
	private String perName;
	
	private Long perResourceId;
	
	public Permission(PermissionLevel perLevelType, String perName, Long perResourceId) {
		this.perLevelType = perLevelType;
		this.perName = perName;
		this.perResourceId = perResourceId;
	}
}
