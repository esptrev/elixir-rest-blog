package trevor_esparza.elixirrestblog.web;


import org.springframework.web.bind.annotation.*;
import trevor_esparza.elixirrestblog.data.Post;
import trevor_esparza.elixirrestblog.data.PostRepository;

import java.util.*;

@RestController
@RequestMapping(value = "/api/posts", headers="Accept=application/json")
public class PostsController {

    private PostRepository postRespository;

    public PostsController(PostRepository postRespository) {
        this.postRespository = postRespository;
    }

    @GetMapping
    public List<Post> getAll(){
        return postRespository.findAll();
    }

    @GetMapping("{blogPostId}")
    public Post getbyId(@PathVariable Long blogPostId){
        Post  queriedPost = postRespository.getById(blogPostId);
        return queriedPost;
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost){
        Post postToAdd = new Post(newPost.getTitle(), newPost.getContent());
        postRespository.save(postToAdd);
        System.out.println("New Post from POstman,createPost function reached" + newPost);
    }

    @PutMapping("{blogPostId}")
    private void updatePost(@PathVariable Long blogPostId, @RequestBody Post updatedPost){
        Post postToUpdate = postRespository.getById(blogPostId);
        postToUpdate.setContent(updatedPost.getContent());
        postToUpdate.setTitle(updatedPost.getTitle());
        System.out.println("Blog post " + blogPostId + " has been updated with " + updatedPost);
    }

    @DeleteMapping("{blogPostId}")
    private void deletePost (@PathVariable Long blogPostId){
        Post postToDelete = postRespository.getById(blogPostId);
        postRespository.delete(postToDelete);
        System.out.println("delete method reached" + blogPostId);
    }












}///END OF CLASS



