package blog.services;

import blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import blog.models.User;

import java.util.List;
import java.util.Objects;
import javax.sql.DataSource;

/**
 * Created by bzhou on 12/09/16.
 */

@Service
@Primary
public class UserServiceJpaImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    DataSource dataSource;

    @Override
    public List<blog.models.User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public blog.models.User findById(Long id) {
        return this.userRepository.findOne(id);
    }

    @Override
    public blog.models.User create(blog.models.User user) {
        return this.userRepository.save(user);
    }

    @Override
    public blog.models.User edit(blog.models.User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        this.userRepository.delete(id);
    }

    @Override
    public void addUser(User user){
        String sql = "insert into users(id, username, full_name, password_hash, email) values (?,?,?,?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int newId = this.userRepository.maxId() + 1;
        jdbcTemplate.update(sql, new Object[] {newId, user.getUsername(), null,
                user.getPasswordHash(), user.getEmail()});
    }

    @Override
    public boolean authenticate(String username, String password) {
        List<User> allUsers = this.userRepository.findAll();
        for (User user: allUsers){
            if (Objects.equals(user.getUsername(), username) && Objects.equals(user.getPasswordHash(), password)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean userNameExist(String username){
        List<User> allUsers = this.userRepository.findAll();
        for (User user: allUsers){
            if (Objects.equals(user.getUsername(), username)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean emailExist(String email){
        List<User> allUsers = this.userRepository.findAll();
        for (User user: allUsers){
            if (Objects.equals(user.getEmail(), email)){
                return true;
            }
        }
        return false;
    }
}
