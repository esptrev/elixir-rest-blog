package trevor_esparza.elixirrestblog.web;


import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import trevor_esparza.elixirrestblog.data.*;
import trevor_esparza.elixirrestblog.services.EmailService;

import java.util.*;

@RestController
@RequestMapping(value = "/api/posts", headers="Accept=application/json")
public class PostsController {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final EmailService emailService;
    private final CategoryRepository categoryRepository;

    public PostsController(PostRepository postRespository, UserRepository userRepository, EmailService emailService, CategoryRepository categoryRepository) {
        this.postRepository = postRespository;
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Post> getAll(){
        return postRepository.findAll();
    }

    @GetMapping("{blogPostId}")
    public Post getbyId(@PathVariable Long blogPostId){
        return postRepository.getById(blogPostId);
    }

//    @PostMapping
//    private void createPost(@RequestBody Post newPost){
//        Post postToAdd = new Post(newPost.getTitle(), newPost.getContent());
//        postToAdd.setAuthor(userRepository.getById(2L));
//        postRepository.save(postToAdd);
//        emailService.prepareAndSend(postToAdd,"New Post Created", "yada yada yada");
//        System.out.println("New Post from POstman,createPost function reached" + newPost);
//    }

    @PostMapping
    private void create(@RequestBody Post newPost, OAuth2Authentication auth){
        String email = auth.getName(); // yes, the email is found under "getName()"
        User user = userRepository.findByEmail(email); // use the email to get the user who made the request
        newPost.setAuthor(user); //set the user to the post
        newPost.setTitle(newPost.getTitle());
        newPost.setContent(newPost.getContent());
        emailService.prepareAndSend(newPost,"New Post Created", "yada yada yada");
        System.out.println("New Post from POstman,createPost function reached" + newPost);
        postRepository.save(newPost); //save the post!

    }

    @PutMapping("{blogPostId}")
    private void updatePost(@PathVariable Long blogPostId, @RequestBody Post updatedPost){
        Post postToUpdate = postRepository.getById(blogPostId);
        postToUpdate.setContent(updatedPost.getContent());
        postToUpdate.setTitle(updatedPost.getTitle());
        postRepository.save(postToUpdate);
        System.out.println("Blog post " + blogPostId + " has been updated with " + updatedPost);
    }

    @DeleteMapping("{blogPostId}")
    private void deletePost (@PathVariable Long blogPostId){
        Post postToDelete = postRepository.getById(blogPostId);
        postRepository.delete(postToDelete);
        System.out.println("delete method reached" + blogPostId);
    }












}///END OF CLASS

//    String email = auth.getName();
//    User user = userRepository.findByEmail(email).get();
//        newPost.setContent(newPost.getContent());
//                newPost.setTitle(newPost.getTitle());
//                newPost.setAuthor(user);
//                postRepository.save(newPost);
//                emailService.prepareAndSend(newPost,"New Post Created", "yada yada yada");
//                System.out.println("New Post from POstman,createPost function reached" + newPost);
//
