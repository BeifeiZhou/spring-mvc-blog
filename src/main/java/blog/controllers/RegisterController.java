package blog.controllers;

import blog.forms.LoginForm;
import blog.models.User;
import blog.services.NotificationService;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bzhou on 05/09/16.
 */
@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping("/users/register")
    public String register(LoginForm registerForm) {
        return "users/register";
    }

    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public String registerPage(@Valid LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/register";
        }

        if (userService.userNameExist(loginForm.getUsername())) {
            notifyService.addErrorMessage("The username is already in use. enter a different username");
            return "users/register";
        } else if (userService.emailExist(loginForm.getEmail())) {
            notifyService.addErrorMessage("The email is already in use. enter a different email");
            return "users/register";
        } else {
            notifyService.addInfoMessage("Register successful!");
            User user = new User(null, loginForm.getUsername(), null, loginForm.getPassword(), loginForm.getEmail());
            userService.addUser(user);
            return "redirect:/users/login";
        }
    }
}

