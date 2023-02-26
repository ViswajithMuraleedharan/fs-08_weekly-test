package com.example.PortalSystem.controller;

import com.example.PortalSystem.model.Book;
import com.example.PortalSystem.services.BookService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping(value = "/book")
    public ResponseEntity saveBook(@RequestBody String bookRequest){
        Book book=setBook(bookRequest);
        int bookId=bookService.saveBook(book);
        return new ResponseEntity<>("book updated at id:-"+bookId, HttpStatus.CREATED);
    }
    @GetMapping(value = "/book")
    public ResponseEntity getBook(@Nullable @RequestParam String bookId){
        JSONArray jsonArray=bookService.getBook(bookId);
        return new ResponseEntity<>(jsonArray.toString(),HttpStatus.OK);
    }

    public Book setBook(String bookRequest) {
        JSONObject jsonObject=new JSONObject(bookRequest);
        Book book=new Book();
        book.setAuthor(jsonObject.getString("author"));
        book.setDesc(jsonObject.getString("desc"));
        book.setTitle(jsonObject.getString("title"));
        book.setPrice(jsonObject.getString("price"));
        return  book;
    }
    @PutMapping(value = "/book/{bookId}")
    public ResponseEntity updateBook(@PathVariable String bookId, @RequestBody String bookrequest){
        Book book=setBook(bookrequest);
        bookService.updateBook(bookId,book);
        return new ResponseEntity<>("book updated successfully",HttpStatus.OK);
    }
    @DeleteMapping(value = "/book")
    public ResponseEntity deleteBook(@RequestParam String bookId){
        bookService.deleteBook(bookId);
        return new ResponseEntity<>("book deleted sucessfully",HttpStatus.OK);
    }
}
