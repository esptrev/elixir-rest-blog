package trevor_esparza.elixirrestblog.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }

    @GetMapping("/hello/{personName}")
    @ResponseBody
    public String sayhello(@PathVariable String personName) {
        return "Hello from " + personName + " !";
    }

    @GetMapping("/increment/{number}")
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }


}///END OF CLASS
