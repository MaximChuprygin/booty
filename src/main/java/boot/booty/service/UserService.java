package boot.booty.service;


import boot.booty.model.Role;
import boot.booty.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUser();
    void createUser(User user);
    void createUser(User user, List<Role> roles);
    void editUser(User user);
    void editUser(User user, List<Role> roles);
    void deleteUser(Long id);
    User getUserById(Long id);
    User findByUsername(String username);
}

