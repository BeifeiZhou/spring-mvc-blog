package blog.services;

/**
 * Created by bzhou on 02/09/16.
 */
public interface UserService {
    boolean authenticate(String username, String password);
}
