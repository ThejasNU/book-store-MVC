package com.pes1ug20cs606.bookStore.service;

import com.pes1ug20cs606.bookStore.model.Book;
import com.pes1ug20cs606.bookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepo;
    public void save(Book b){
        bookRepo.save(b);
    }

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public Book getBookById(int id){
        return bookRepo.findById(id).get();
    }

    public void deleteBook(int id){
        bookRepo.deleteById(id);
    }
}
