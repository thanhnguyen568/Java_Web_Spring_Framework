package be.ss12ajax.service;

import be.ss12ajax.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService extends GeneralService<Blog>{
    List<Blog> search(String description, String title);
}
