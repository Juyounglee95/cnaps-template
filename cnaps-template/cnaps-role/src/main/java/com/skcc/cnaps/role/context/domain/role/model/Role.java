package com.skcc.cnaps.role.context.domain.role.model;

import javax.persistence.Entity;

import com.skcc.cnaps.shared.share.base.domain.AbstractEntity;
import com.skcc.cnaps.shared.share.base.domain.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Role extends AbstractEntity implements AggregateRoot{
	
	private String roleName;
	private Long permissionId;
	private Boolean roleUsage = false; //default
	
	public Role(String roleName, Long permissionId, Boolean roleUsage) {
		this.roleName = roleName;
		this.permissionId =permissionId;
		this.roleUsage =roleUsage;
	}
}
