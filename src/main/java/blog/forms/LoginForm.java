package blog.forms;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by bzhou on 02/09/16.
 */
public class LoginForm {
    @NotBlank
    @Size(min=2, max=30, message = "Username size should be in the range [2...30]")
    private String username;

    @NotBlank
    @Size(min=1, max=50)
    private String password;

    @NotBlank
    @Email
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail(){ return email;}
    public void setEmail(String email){this.email = email;}
}
