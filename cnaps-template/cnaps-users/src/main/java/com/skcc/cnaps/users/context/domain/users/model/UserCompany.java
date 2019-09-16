package com.skcc.cnaps.users.context.domain.users.model;

import javax.persistence.Embeddable;

import com.skcc.cnaps.shared.share.base.domain.ValueObject;

import lombok.Data;

@Embeddable
@Data
public class UserCompany implements ValueObject {
	
	private String companyName;
	
	public UserCompany(String companyName) {
		this.companyName = companyName;
	}
	
}
