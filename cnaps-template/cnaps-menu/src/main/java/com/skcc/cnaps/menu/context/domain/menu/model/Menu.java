package com.skcc.cnaps.menu.context.domain.menu.model;

import javax.persistence.Entity;

import com.skcc.cnaps.shared.share.base.domain.AbstractEntity;
import com.skcc.cnaps.shared.share.base.domain.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Menu extends AbstractEntity implements AggregateRoot{
	
	private String menuName;
	
	private Long menuGroupId;
	
	private Boolean menuUsage = false;
	
	public Menu(String menuName) {
		this.menuName = menuName;
	}

}
