package com.priyankrege.spring2019.controller;

import com.priyankrege.spring2019.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.priyankrege.spring2019.service.BookService;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

//    Add new book
    @PostMapping("/book")
    public ResponseEntity<?> save(@RequestBody Book book){
        long id = bookService.save(book);
        return  ResponseEntity.ok().body("New book added"+id);
    }

//    Get a book by id
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> get(@PathVariable("id") long id){
        Book book = bookService.get(id);
        return ResponseEntity.ok().body(book);
    }

//    Get all the books
    @GetMapping("/book")
    public ResponseEntity<List<Book>> list(){
        List<Book> books = bookService.list();
        return  ResponseEntity.ok().body(books);
    }

//    Update a book
    @PutMapping("/book/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id,@RequestBody Book book){
        bookService.update(id, book);
        return ResponseEntity.ok().body("The book had been updated");
    }

//    Delete a book
    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        bookService.delete(id);
        return  ResponseEntity.ok().body("Deleted book");
    }
}
