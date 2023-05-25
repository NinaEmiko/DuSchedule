package com.DuSchedule.demo;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        try {
            Book[] books = bookService.getBooks();
            model.addAttribute("books", books);
            System.out.println("Books: " + Arrays.toString(books));
            return "books";
        } catch (Exception e) {
            model.addAttribute("error", "Failed to fetch books");
            return "error";
        }
    }

}
