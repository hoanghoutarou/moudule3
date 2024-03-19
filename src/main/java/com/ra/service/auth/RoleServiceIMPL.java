package com.ra.service.auth;


import com.ra.model.entity.Role;
import com.ra.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceIMPL implements IRoleService {
	
	@Autowired
	private IRoleRepository roleRepository;
	
	@Override
	public Role findByRoleName(String roleName) {
		Role roles = roleRepository.findByName(roleName).orElseThrow(() -> new RuntimeException("role not found"));
		return roles;
	}

	@Override
	public List<Role> getAll() {
		return roleRepository.findAll();
	}
}
