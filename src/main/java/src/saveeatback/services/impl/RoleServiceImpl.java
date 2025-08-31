package src.saveeatback.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.saveeatback.datas.entities.Role;
import src.saveeatback.datas.repositories.RoleRepository;
import src.saveeatback.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role createRole(Role role) {
        return this.roleRepository.save(role);
    }
}
