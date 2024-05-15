package com.BookManagement.service;


import com.BookManagement.dto.BookDto;

import java.util.List;

public interface BookService {


    void saveBook(BookDto bookDto);

    List<BookDto> getBooks();

    void deleteBookById(Long id);

    BookDto getBookById(Long id);

    List<BookDto> searchBooks(String query);
}
