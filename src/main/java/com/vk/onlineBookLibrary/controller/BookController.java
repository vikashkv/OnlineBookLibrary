package com.vk.onlineBookLibrary.controller;

import com.vk.onlineBookLibrary.entity.Books;
import com.vk.onlineBookLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/book-service")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/find-all-books")
    public ResponseEntity<List<Books>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/get-BookBy-SkuCode/{skuCode}")
    public ResponseEntity<Books> getBookBySkuCode(@PathVariable String skuCode) {
        return new ResponseEntity<>(bookService.getBookBySkuCode(skuCode), HttpStatus.OK);
    }

    @PostMapping("/create-books")
    public ResponseEntity<String> createBooks(@RequestBody Books books) {
      return new ResponseEntity<>(bookService.createBooks(books), HttpStatus.CREATED);
    }

    @PutMapping("/update-book")
    public ResponseEntity<String> updateBook(@RequestBody Books books) {
        return new ResponseEntity<>(bookService.updateBookBySkuCode(books), HttpStatus.OK);
    }


    @DeleteMapping("/delete-book-BySkuCode/{skuCode}")
    public ResponseEntity<String> deleteBySkuCode(@PathVariable String skuCode) {
        return new ResponseEntity<>(bookService.deleteBySkuCode(skuCode), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<String> deleteAllData() {
        return new ResponseEntity<>(bookService.deleteAllBooks(), HttpStatus.NO_CONTENT);
    }
}
