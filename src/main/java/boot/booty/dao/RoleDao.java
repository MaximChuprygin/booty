package boot.booty.dao;


import boot.booty.model.Role;

import java.util.List;

public interface RoleDao {
    void addRole(Role user);
    List<Role> listRoles();
    List<Role> getByName(String name);
}
