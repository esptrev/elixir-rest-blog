package trevor_esparza.elixirrestblog.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/jason")
public class PostController {

}
