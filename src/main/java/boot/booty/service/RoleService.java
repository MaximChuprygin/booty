package boot.booty.service;


import boot.booty.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRole();
    List<Role> getByName(String name);
}

