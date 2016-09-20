package blog.services;

import blog.models.User;

import java.util.List;

/**
 * Created by bzhou on 02/09/16.
 */
public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User create(User user);
    User edit(User user);
    void deleteById(Long id);
    boolean authenticate(String username, String password);
    boolean userNameExist(String username);
    boolean emailExist(String email);
    void addUser(User user);
}

