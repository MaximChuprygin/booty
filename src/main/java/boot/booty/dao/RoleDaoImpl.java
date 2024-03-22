package boot.booty.dao;


import boot.booty.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void addRole(Role user) {
        entityManager.persist(user);
    }

    public Role findByIdRole(Long id) {
        return entityManager.find(Role.class, id);
    }

    public List<Role> listRoles() {
        return entityManager.createQuery("select role from Role role", Role.class).getResultList();
    }

    public Role findByName(String name) {
        return entityManager.createQuery("select role from Role role where role.role = :id", Role.class)
                .setParameter("id", name)
                .getResultList().stream().findAny().orElse(null);
    }

    public List<Role> listByName(List<String> name) {
        return  entityManager.createQuery("select role from Role role where role.role in (:id)", Role.class)
                .setParameter("id", name)
                .getResultList();
    }

    public List<Role> getByName(String name) {
        TypedQuery<Role> query = entityManager.createQuery("select role from Role role where role.role = :id", Role.class);
        query.setParameter("id", name);
        return query.getResultStream().collect(Collectors.toList());
    }
}
