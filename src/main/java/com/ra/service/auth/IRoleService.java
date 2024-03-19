package com.ra.service.auth;

import com.ra.model.entity.Role;

import java.util.List;

public interface IRoleService {
    Role findByRoleName(String roleName);
    List<Role> getAll();

}
