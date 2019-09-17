package com.skcc.cnaps.role.application.sp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.cnaps.role.context.domain.RoleService;
import com.skcc.cnaps.role.context.domain.permission.model.Permission;
import com.skcc.cnaps.role.context.domain.permission.model.PermissionLevel;
import com.skcc.cnaps.role.context.domain.permission.repository.PermissionRepository;

@RestController
@RequestMapping(value="/ver1")
public class RoleController implements RoleService{
	@Autowired
	PermissionRepository perRepository;
	
	@PostMapping("/roleservice/createper")
	public Permission createPer(PermissionLevel perLevelType, String perName, Long perResourceId) {
		Permission per = new Permission(perLevelType, perName, perResourceId);
		return perRepository.save(per);
	}
	
	@GetMapping("/roleservice/getper")
	public List<Permission> getPerList(PermissionLevel perLevelType){
		return perRepository.findByPerLevelType(perLevelType);
	}
}
