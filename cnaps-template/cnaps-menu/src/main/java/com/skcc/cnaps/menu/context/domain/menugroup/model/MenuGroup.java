package com.skcc.cnaps.menu.context.domain.menugroup.model;

import javax.persistence.Entity;

import com.skcc.cnaps.shared.share.base.domain.AbstractEntity;
import com.skcc.cnaps.shared.share.base.domain.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class MenuGroup  extends AbstractEntity implements AggregateRoot{
	
	private String menuGroupName;
	
	private Boolean menuGroupUsage = false; //default
	
	public MenuGroup(String menuGroupName) {
		this.menuGroupName =menuGroupName;
	}
}
