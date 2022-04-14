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

    @GetMapping("{blogPostId}")
    public Post getbyId(@PathVariable Long blogPostId){
        return new Post(blogPostId, "new post from getbyID", "blah blah blah blah blah");
    }


    @PostMapping
    private void createPost(@RequestBody Post newPost){
        System.out.println("New Post from POstman" + newPost);
    }


    @PutMapping("{blogPostId}")
    private void updatePost(@PathVariable Long blogPostId, @RequestBody Post updatedPost){
        System.out.println("Blog post " + blogPostId + " has been updated with " + updatedPost);
    }

    @DeleteMapping("{blogPostId}")
    private void deletePost (@PathVariable Long blogPostId){
        System.out.println("delete method reached" + blogPostId);
    }












}///END OF CLASS



