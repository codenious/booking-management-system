package com.BookManagement.mapper;

import com.BookManagement.dto.BookDto;
import com.BookManagement.entity.Book;

public class BookMapper {

    public static BookDto BookToBookDto(Book book){

        BookDto bookDto = new BookDto();
        bookDto.setBookName(book.getBookName());
        bookDto.setDescription(book.getDescription());
        bookDto.setWriterName(book.getWriterName());
        bookDto.setId(book.getId());

        return bookDto;
    }

    public static Book BookDtoToBook(BookDto bookDto){

        Book book = new Book();
        book.setBookName(bookDto.getBookName());
        book.setDescription(bookDto.getDescription());
        book.setWriterName(bookDto.getWriterName());
        book.setId(bookDto.getId());

        return book;
    }
}
