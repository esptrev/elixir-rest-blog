package trevor_esparza.elixirrestblog.web;


import org.springframework.web.bind.annotation.*;
import trevor_esparza.elixirrestblog.data.Post;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/jason")

public class PostsController {
    Post blogOne = new Post(1L, "blogone", "woohoo");
    Post blogTwo = new Post(2L, "blogtwo", "woohoowoohoo");
    Post blogThree = new Post(3L, "blogthree", "woohoowoohoowoohoo");
//    Post blogFour = new Post();
     List<Post> blogPosts = new ArrayList<>();

    @GetMapping
    private List<Post> getPosts() {

        blogPosts.add(blogOne);
        blogPosts.add(blogTwo);
        blogPosts.add(blogThree);

        return blogPosts;
    }


    @GetMapping("{blogPostID}")
    public Post getById(@PathVariable Long blogPostID) {
        return new Post(4L, "My first post", "WoohooWoohooWoohooWoohoo");
    }


}
