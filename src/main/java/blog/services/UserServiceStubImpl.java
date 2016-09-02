package blog.services;

import org.springframework.stereotype.Service;
import java.util.Objects;

/**
 * Created by bzhou on 02/09/16.
 */
@Service
public class UserServiceStubImpl implements UserService {
    @Override
    public boolean authenticate(String username, String password) {
        return Objects.equals(username, password);
    }
}
