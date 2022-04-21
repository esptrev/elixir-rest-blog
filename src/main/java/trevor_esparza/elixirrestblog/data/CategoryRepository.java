package trevor_esparza.elixirrestblog.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository <Category,Long> {


    List<Category> findCategoryByName(String categoryName);
}
