package baitap.ss5ormhibernate.service;

import baitap.ss5ormhibernate.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {
    Comment findById(Long no);

    void save(Comment comment);

    void remove(Long no);

    List<Comment> findAll();

//    Page<Comment> findAllWithPaging(Pageable pageable);

//    List<Comment> searchAll(String customerName, String customerAddress, String customerTel);

//    Page<Comment> searchAllWithPage(String customerName, String customerAddress, Pageable pageable);

    //    Check duplicate code
    Comment findByCustomerCodeContaining(String customerCode);
}
