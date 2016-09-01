package blog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bzhou on 01/09/16.
 */

@Controller
public class HomeController {
@RequestMapping("/")
    public String index(){
        return "index";
    }
}
