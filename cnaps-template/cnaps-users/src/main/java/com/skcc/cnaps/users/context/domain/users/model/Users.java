package com.skcc.cnaps.users.context.domain.users.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Transient;

import com.skcc.cnaps.shared.share.base.domain.AbstractEntity;
import com.skcc.cnaps.shared.share.base.domain.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper =true)
@Entity
public class Users extends AbstractEntity implements AggregateRoot{
	
	private String userName;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "GROUP_LIST", joinColumns = @JoinColumn(name="USERS_ID"))
    @OrderColumn
	private List<Long> userGroupId= new ArrayList<>();
	
	@Embedded
	private UserCompany userCompany;
	
	public Users() {
		
	}
	public Users(String userName) {
		this.userName = userName;
		
	}
	
}
