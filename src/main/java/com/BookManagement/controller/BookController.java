package com.BookManagement.controller;

import com.BookManagement.dto.BookDto;
import com.BookManagement.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@Controller
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/home")
    public String homePage(Model model){
        List<BookDto> bookDto = bookService.getBooks();
        model.addAttribute("bookDto",bookDto);
        return "home-page";
    }

    @GetMapping("/home/add")
    public String addBookPage(Model model){
        BookDto bookDto = new BookDto();
        model.addAttribute("bookDto",bookDto);
        return "add-book";
    }

    //Need to understand this code. I failed here!!!!
    @PostMapping("/home/add/post")
    public String addBook(@ModelAttribute("bookDto") BookDto bookDto){
        bookService.saveBook(bookDto);
        return "redirect:/home";
    }


    @GetMapping("/home/{id}/delete")
    public String deleteBookById(@PathVariable("id") Long id){
        bookService.deleteBookById(id);
        return"redirect:/home";
    }

    @GetMapping("/home/{bookId}/edit")
    public String editBook(Model model, @PathVariable("bookId") Long id){
        BookDto bookDto = bookService.getBookById(id);
        model.addAttribute("bookDto",bookDto);
        return "edit-book";
    }

    @PostMapping("/home/{bookId}")
    public String updateBookById(@ModelAttribute BookDto bookDto, @PathVariable("bookId") Long id, Model model){
        bookDto.setId(id);
        bookService.saveBook(bookDto);
        model.addAttribute("bookDto",bookDto);
        return "redirect:/home";
    }

    @GetMapping("/home/{id}/info")
    public String showBookInfo(@PathVariable("id") Long id,Model model){
        BookDto bookDto = bookService.getBookById(id);
        model.addAttribute("bookDto",bookDto);
        return "info-book";
    }


    @GetMapping("/home/search")
    public String SearchBooks(@RequestParam("query") String query, Model model){
        List<BookDto> bookDtoList = bookService.searchBooks(query);
        model.addAttribute("bookDtoList", bookDtoList);
        return "search-book";
    }

}
