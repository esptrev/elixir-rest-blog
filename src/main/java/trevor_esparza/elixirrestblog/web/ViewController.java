package trevor_esparza.elixirrestblog.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {



    @RequestMapping(value = {"/", "/about", "/posts", "/login", "/home", "/register"}, method = RequestMethod.GET)
    public String showView(){
        return "forward:/index.html";
    }






}///END OF CLASS
