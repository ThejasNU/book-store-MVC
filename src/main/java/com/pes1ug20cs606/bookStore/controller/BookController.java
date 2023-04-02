package com.pes1ug20cs606.bookStore.controller;

import com.pes1ug20cs606.bookStore.model.Book;
import com.pes1ug20cs606.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @GetMapping("/")
    public String startApplication(){
        return "home";
    }

    @GetMapping("/bookRegister")
    public String bookRegister(){
        return "bookRegister";
    }

    @GetMapping("/availableBooks")
    public ModelAndView availableBooks(){
        List<Book> bookList=bookService.getAllBooks();
        ModelAndView m=new ModelAndView();
        m.setViewName("availableBooks");
        m.addObject("books",bookList);
        return m;
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b){
        bookService.save(b);
        return "redirect:/availableBooks";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        Book b=bookService.getBookById(id);
        model.addAttribute("book",b);
        return "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteBook(id);
        return "redirect:/availableBooks";
    }
}
