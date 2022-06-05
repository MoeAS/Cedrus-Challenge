package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info(){
        return "The application is running...";
    }

    @RequestMapping(value = "createbook", method = RequestMethod.POST)
    public String createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @RequestMapping(value = "readbooks", method = RequestMethod.GET)
    public List<Book> readBooks(){
        return bookService.readBooks();
    }

    @RequestMapping(value = "readbook/{book}", method = RequestMethod.GET)
    public List<Book> readBook(@PathVariable("book") Book book){
        return bookService.readBook(book);
    }

    @RequestMapping(value = "updatebook", method = RequestMethod.PUT)
    public String updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @RequestMapping(value = "searchbook", method = RequestMethod.POST)
    public List<Book> searchBook(@RequestBody Book book){
        return bookService.searchBook(book);
    }

    @RequestMapping(value = "deletebook", method = RequestMethod.DELETE)
    public String deleteBook(@RequestBody Book book){
        return bookService.deleteBook(book);
    }
}
