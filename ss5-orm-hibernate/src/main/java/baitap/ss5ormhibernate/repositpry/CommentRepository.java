package baitap.ss5ormhibernate.repositpry;

import baitap.ss5ormhibernate.model.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
}
