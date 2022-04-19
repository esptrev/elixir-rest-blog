package trevor_esparza.elixirrestblog.web;


import org.springframework.web.bind.annotation.*;
import trevor_esparza.elixirrestblog.data.Post;
import trevor_esparza.elixirrestblog.data.User;

import java.util.*;

@RestController
@RequestMapping(value = "/api/posts", headers="Accept=application/json")
public class PostsController {

   private static final User author1 = new User(1L,"postControllerUser1","postcontrolemail1","ddddd",null, User.Role.USER,null);
   private static final User author2 = new User(2L,"postControllerUser2","postcontrolemail2","aaaaaa",null, User.Role.USER,null);
   private static final User author3 = new User(3L,"postControllerUser3","postcontrolemail3","xxxxxx",null, User.Role.USER,null);

    @GetMapping
    public List<Post> getAll(){
        List<Post> posts = new ArrayList<>();

        posts.add(new Post(1L, "blogone", "one one one", author1));
        posts.add(new Post(2L, "blogtwo", "two two two", author1));
        posts.add(new Post(3L, "blogthree", "three three three",author2));
        posts.add(new Post(4L, "blogfour", "four four four", author2));
        posts.add(new Post(5L, "blogfive", "five five five", author3));
        posts.add(new Post(6L, "blogsix", "six six six", author3));
        posts.add(new Post(7L, "blogseven", "seven seven seven", author1));
        posts.add(new Post(8L, "blogeight", "eight eight eight", author1));
        posts.add(new Post(9L, "blognine", "nine nine nine",author1));
        posts.add(new Post(10L, "blogten", "ten ten ten", author2));
        System.out.println(posts);
        return posts;
    }

    @GetMapping("{blogPostId}")
    public Post getbyId(@PathVariable Long blogPostId){
        return new Post(blogPostId, "new post from getbyID", "blah blah blah blah blah", author1);
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



