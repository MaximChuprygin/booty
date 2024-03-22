package boot.booty.dao;




import boot.booty.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    List<User> findAll();
    User findByUsername(String username);
    void delete(Long id);
    void update(User user);
    User getUserById(Long id);
}
