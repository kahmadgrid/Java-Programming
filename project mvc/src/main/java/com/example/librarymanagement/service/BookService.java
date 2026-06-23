package com.example.librarymanagement.service;

import com.example.librarymanagement.exception.BookNotFoundException;
import com.example.librarymanagement.exception.DuplicateIsbnException;
import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll(String keyword) {
        return bookRepository.search(keyword);
    }

    public BookPage findPage(String keyword, int page, int size) {
        List<Book> matchedBooks = bookRepository.search(keyword);
        int pageSize = Math.max(1, Math.min(size, 20));
        int totalItems = matchedBooks.size();
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);
        int currentPage = Math.max(0, page);

        if (totalPages > 0 && currentPage >= totalPages) {
            currentPage = totalPages - 1;
        }

        int fromIndex = totalPages == 0 ? 0 : currentPage * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, totalItems);
        List<Book> books = matchedBooks.subList(fromIndex, toIndex);

        return new BookPage(books, currentPage, pageSize, totalPages, totalItems, keyword);
    }

    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    public Book save(Book book) {
        bookRepository.findByIsbn(book.getIsbn().trim())
                .filter(existingBook -> !existingBook.getId().equals(book.getId()))
                .ifPresent(existingBook -> {
                    throw new DuplicateIsbnException(book.getIsbn());
                });

        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        boolean deleted = bookRepository.deleteById(id);
        if (!deleted) {
            throw new BookNotFoundException(id);
        }
    }
}
