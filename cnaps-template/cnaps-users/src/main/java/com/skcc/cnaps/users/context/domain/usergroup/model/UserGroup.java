package com.skcc.cnaps.users.context.domain.usergroup.model;

import javax.persistence.Entity;

import com.skcc.cnaps.shared.share.base.domain.AbstractEntity;
import com.skcc.cnaps.shared.share.base.domain.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class UserGroup extends AbstractEntity implements AggregateRoot{
	
	private String userGroupName;
	private Boolean userGroupUsage=false;
	
	public UserGroup(String userGroupName) {
		this.userGroupName = userGroupName;
	}
}
