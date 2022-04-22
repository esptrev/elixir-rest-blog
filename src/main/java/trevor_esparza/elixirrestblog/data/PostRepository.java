package trevor_esparza.elixirrestblog.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findAllByCategoriesIn(Collection<Category> categories);
    Post findByTitle(String title); // select * from posts where title = ?
    Post findFirstByTitle(String title); // select * from posts where title = ? limit 1


    // The following method is equivalent to the built in `getOne` method, there's no need to create this example
    @Query("from Post a where a.id like ?1")
    Post getPostById(long id);

    // The following method shows you how to use named parameters in a HQL custom query:
    @Query("from Post a where a.title like %:term%")
    List<Post> searchByTitleLike(@Param("term") String term);
}

