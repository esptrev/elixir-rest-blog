package trevor_esparza.elixirrestblog.web;

import org.springframework.web.bind.annotation.*;
import trevor_esparza.elixirrestblog.data.Post;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/jason")
public class PostsController {


@GetMapping
    private List<Post> getAll(){
    ArrayList<Post> posts = new ArrayList<>();
    posts.add(new Post(1L, "blogone", "woohoo"));
    posts.add(new Post(2L, "blogtwo", "woohoowoohoo"));
    posts.add(new Post(3L, "blogthree", "woohoowoohoowoohoo"));
    return posts;
}


@GetMapping("{blogPostId}")
    public Post getById(@PathVariable Long blogPostId){
    return new Post(blogPostId,"blogblog", "blogblogblogblogblog");
}




}///END OF CLASS



//@GetMapping
//    private List<Post> getPost() {
//        Post blogOne = new Post(1L, "blogone", "woohoo");
//        Post blogTwo = new Post(2L, "blogtwo", "woohoowoohoo");
//        Post blogThree = new Post(3L, "blogthree", "woohoowoohoowoohoo");
//
//        ArrayList <Post> blogPosts = new ArrayList <> ();
//
//        blogPosts.add(blogOne);
//        blogPosts.add(blogTwo);
//        blogPosts.add(blogThree);
//        System.out.println(blogPosts);
//        return blogPosts;
//    }


//    @GetMapping("{blogPostID}")
//    public Post getById(@PathVariable Long blogPostID) {
//        return new Post(4L, "My first post", "WoohooWoohooWoohooWoohoo");
//    }

