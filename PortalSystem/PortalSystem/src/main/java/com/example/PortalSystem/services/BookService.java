package com.example.PortalSystem.services;

import com.example.PortalSystem.dao.BookRepo;
import com.example.PortalSystem.model.Book;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepo bookRepo;
    public int saveBook(Book book){
        Book book1=bookRepo.save(book);
        int bookId=book1.getID();
        return bookId;
    }

    public JSONArray getBook(String bookId) {
        JSONArray jsonArray=new JSONArray();
        if(bookId!=null && bookRepo.findById(Integer.valueOf(bookId)).isPresent()){
            Book book=bookRepo.findById(Integer.valueOf(bookId)).get();
            JSONObject jsonObject=setBook(book);
            jsonArray.put(jsonObject);
        }
        else{
            List<Book> bookList=bookRepo.findAll();
            for(Book book:bookList){
                JSONObject jsonObject=setBook(book);
                jsonArray.put(jsonObject);
            }
        }
        return jsonArray;
    }

    private JSONObject setBook(Book book) {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("id",book.getID());
        jsonObject.put("title",book.getTitle());
        jsonObject.put("author",book.getAuthor());
        jsonObject.put("desc",book.getDesc());
        jsonObject.put("price",book.getPrice());
        return jsonObject;
    }

    public void updateBook(String bookId, Book newbook) {
        if(bookId!=null && bookRepo.findById(Integer.valueOf(bookId)).isPresent()){
            Book book=bookRepo.findById(Integer.valueOf(bookId)).get();
            newbook.setID(book.getID());
            bookRepo.save(newbook);
        }
    }
    public void deleteBook(String bookId){
        if(bookId!=null && bookRepo.findById(Integer.valueOf(bookId)).isPresent()){
            bookRepo.deleteById(Integer.valueOf(bookId));
        }
    }
}
