package trevor_esparza.elixirrestblog.web;


import org.springframework.web.bind.annotation.*;
import trevor_esparza.elixirrestblog.data.CategoryRepository;
import trevor_esparza.elixirrestblog.data.PostRepository;
import trevor_esparza.elixirrestblog.data.UserRepository;

@RestController
@RequestMapping(value = "/api/categories", headers="Accept=application/json")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public CategoryController(CategoryRepository categoryRepository, PostRepository postRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    //    @GetMapping("/categoryName")
//    public List<Category> getPostsByCategory(@RequestParam String categoryName){
//      Category cat =  categoryRepository.
//        return cat.getPost();
//
//    }



}
