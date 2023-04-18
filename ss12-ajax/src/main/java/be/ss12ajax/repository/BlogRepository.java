package be.ss12ajax.repository;


import be.ss12ajax.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {
    List<Blog> findAllByDescriptionContainingOrTitleContaining(
            String title,
            String description);
}
