package trevor_esparza.elixirrestblog.web;


import org.springframework.web.bind.annotation.*;
import trevor_esparza.elixirrestblog.data.Post;

import java.util.*;

@RestController
@RequestMapping(value = "/api/posts", headers="Accept=application/json")
public class PostsController {

    @GetMapping
    public List<Post> getAll(){
        List<Post> posts = new ArrayList<>();
        System.out.println(posts);
        posts.add(new Post(1L, "blogone", "woohoo"));
        posts.add(new Post(2L, "blogtwo", "woohoowoohoo"));
        posts.add(new Post(3L, "blogthree", "woohoowoohoowoohoo"));
        System.out.println(posts);
        return posts;
    }








}///END OF CLASS



