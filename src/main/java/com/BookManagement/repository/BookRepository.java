package com.BookManagement.repository;

import com.BookManagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {


    List<Book> findByBookNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrWriterNameContainingIgnoreCase(String bookName, String description , String writerName);

}
