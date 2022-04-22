package trevor_esparza.elixirrestblog.web;


import org.springframework.web.bind.annotation.*;
import trevor_esparza.elixirrestblog.data.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/categories", headers = "Accept=application/json")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public CategoryController(CategoryRepository categoryRepository, PostRepository postRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/categoryName")
    public List<Post> getPostsByCategory(@RequestParam String categoryName) {
        return postRepository.findAllByCategoriesIn(categoryRepository.findCategoryByName(categoryName));

    }

    @GetMapping("/titleKeyword")
    private List<Post> searchPostsByTitleKeyword(@RequestParam String keyword){
        return postRepository.searchByTitleLike(keyword);
    }


}
