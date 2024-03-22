package boot.booty.service;


import boot.booty.dao.RoleDaoImpl;
import boot.booty.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDaoImpl roleDao;

    @Autowired
    public RoleServiceImpl(RoleDaoImpl roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getAllRole() {
        return roleDao.listRoles();
    }

    @Override
    public List<Role> getByName(String name) {
        return roleDao.getByName(name);
    }
}
