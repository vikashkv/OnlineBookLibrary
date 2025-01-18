package com.vk.onlineBookLibrary.service;

import com.vk.onlineBookLibrary.entity.Books;
import com.vk.onlineBookLibrary.exceptions.BookAlreadyExistsException;
import com.vk.onlineBookLibrary.exceptions.NoSuchBookExistsException;
import com.vk.onlineBookLibrary.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class BookService {
    @Autowired
    BookRepository bookRepository;


    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }

    public Books getBookBySkuCode(String skuCode) {
        Books book = bookRepository.findBySkuCode(skuCode);
        if (book == null) {
            log.error("No book found with SKU Code while getting from DB {}", skuCode);
            throw new NoSuchBookExistsException("No Book present with SKU Code: " + skuCode);
        }
        return book;
    }

    @Transactional
    public String createBooks(Books books) {
        if (bookRepository.existsBySkuCode(books.getSkuCode())) {
            log.warn("Book with SKU Code {} already exists", books.getSkuCode());
            throw new BookAlreadyExistsException("Book with SKU Code " + books.getSkuCode() + " already exists.");
        }
        books.setBookPublished(LocalDateTime.now());
        bookRepository.save(books);
        log.info("Book with SKU Code {} added successfully", books.getSkuCode());
        return "Book Added Successfully!!";
    }

    @Transactional
    public String deleteBySkuCode(String skuCode) {
        Books book = bookRepository.findBySkuCode(skuCode);
        if (book == null) {
            log.error("No book found with SKU Code while deleting {}", skuCode);
            throw new NoSuchBookExistsException("No Book present with SKU Code: " + skuCode);
        }
        bookRepository.deleteBySkuCode(skuCode);
        log.info("Book with SKU Code {} deleted successfully", skuCode);
        return "Book Deleted Successfully!!";
    }

    @Transactional
    public String deleteAllBooks() {
        bookRepository.deleteAll();
        log.info("All books deleted successfully");
        return "All Books Deleted Successfully!!";
    }

    @Transactional
    public String updateBookBySkuCode(Books books) {
        Books existingBook = bookRepository.findBySkuCode(books.getSkuCode());
        if (existingBook == null) {
            log.error("No book found with SKU Code while updating book {}", books.getSkuCode());
            throw new NoSuchBookExistsException("No Book present with SKU Code: " + books.getSkuCode());
        }
        books.setId(existingBook.getId());
        books.setSkuCode(books.getSkuCode());
        books.setBookPublished(LocalDateTime.now());
        books.setBookName(books.getBookName());
        books.setBookAuthor(books.getBookAuthor());
        bookRepository.save(books);
        log.info("Book with SKU Code {} updated successfully", books.getSkuCode());
        return "Book Updated Successfully!!";
    }


}
