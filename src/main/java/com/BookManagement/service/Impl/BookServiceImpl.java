package com.BookManagement.service.Impl;

import com.BookManagement.dto.BookDto;
import com.BookManagement.entity.Book;
import com.BookManagement.mapper.BookMapper;
import com.BookManagement.repository.BookRepository;
import com.BookManagement.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    @Override
    public void saveBook(BookDto bookDto) {
        Book book = BookMapper.BookDtoToBook(bookDto);
        System.out.println(book.getId() + " " + book.getBookName() + " " + book.getWriterName() + " " + book.getDescription());
        bookRepository.save(book);
    }

    @Override
    public List<BookDto> getBooks() {
        return bookRepository.findAll().stream().map(BookMapper::BookToBookDto).collect(Collectors.toList());
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).get();
        return BookMapper.BookToBookDto(book);
    }

    @Override
    public List<BookDto> searchBooks(String query) {
        List<Book> books = bookRepository.findByBookNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrWriterNameContainingIgnoreCase(query,query,query);
        return books.stream().map(BookMapper::BookToBookDto).collect(Collectors.toList());
    }
}
