package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public String createBook(Book book){
        try {
            if (!bookRepository.existsByName(book.getName())){
                book.setId(null == bookRepository.findMaxId()? 0 : bookRepository.findMaxId() + 1);
                bookRepository.save(book);
                return "Book record created successfully.";
            }else {
                return "Book already exists in the database.";
            }
        }catch (Exception e){
            throw e;
        }
    }

    public List<Book> readBooks(){
        return bookRepository.findAll();
    }

    public List<Book> readBook(Book book){
        return bookRepository.findByName(book.getName());
    }

    public List<Book> searchBook(Book book){
        return bookRepository.searchByTitleLike(book.getName());
    }

    @Transactional
    public String updateBook(Book book){
        if (bookRepository.existsByName(book.getName())){
            try {
                List<Book> books = bookRepository.findByName(book.getName());
                books.stream().forEach(s -> {
                    Book bookToBeUpdate = bookRepository.findById(s.getId()).get();
                    bookToBeUpdate.setName(book.getName());
                    bookToBeUpdate.setRating(book.getRating());
                    bookRepository.save(bookToBeUpdate);
                });
                return "Book record updated.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "Book does not exists in the database.";
        }
    }

    @Transactional
    public String deleteBook(Book book){
        if (bookRepository.existsByName(book.getName())){
            try {
                List<Book> books = bookRepository.findByName(book.getName());
                books.stream().forEach(s -> {
                    bookRepository.delete(s);
                });
                return "Book record deleted successfully.";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "Book does not exist";
        }
    }
}
