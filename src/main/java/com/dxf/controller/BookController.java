package com.dxf.controller;

import com.dxf.beans.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping
public class BookController {

    public List setBooks(){
        List<Book> list = new ArrayList<Book>();
        list.add(new Book(1,"SpringBoot"));
        list.add(new Book(2,"SpringCloud"));
        list.add(new Book(3,"Redis"));
        list.add(new Book(4,"Maven"));
        return list;
    }

    @GetMapping("GET/books/{id}")
    public List getBooksById(@PathVariable int id){
        List<Book> rList = new ArrayList<>();
        List<Book> list = setBooks();
        for (Book o : list) {
            if (o.getId()==id){
                rList.add(o);
            }
        }
        return rList;
    }
    @GetMapping("GET/books")
    public List getBooks(){
        List<Book> rList = setBooks();
        return rList;
    }

    @DeleteMapping("DELETE/books/{id}")
    public boolean deleteBooks(@PathVariable int id){
        List<Book> list = setBooks();
        boolean flag = false;
        Iterator<Book> iterator = list.iterator();
        while (iterator.hasNext()){
            Book book = iterator.next();
            if (book.getId()==id){
                iterator.remove();
                flag = true;
            }
        }
        return flag;
    }

    @PostMapping("PUT/books")
    public boolean updateBooks(@RequestBody Book book){
        List<Book> list = setBooks();
        boolean flag = false;
        for (Book o : list) {
            if (o.getId()==book.getId()){
                o.setName(book.getName());
                flag = true;
            }
        }
        return flag;
    }



}
