package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BookRepository {

    private final ConcurrentMap<Long, Book> books = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong();

    public BookRepository() {
        save(new Book(null, "Clean Code", "Robert C. Martin", "9780132350884", 4));
        save(new Book(null, "Effective Java", "Joshua Bloch", "9780134685991", 3));
        save(new Book(null, "Spring in Action", "Craig Walls", "9781617294945", 5));
    }

    public List<Book> findAll() {
        return books.values()
                .stream()
                .sorted(Comparator.comparing(Book::getId))
                .toList();
    }

    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(books.get(id));
    }

    public Book save(Book book) {
        if (book.getId() == null) {
            book.setId(sequence.incrementAndGet());
        }

        books.put(book.getId(), copyOf(book));
        return book;
    }

    public void deleteById(Long id) {
        books.remove(id);
    }

    public List<Book> search(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return findAll();
        }

        String normalizedKeyword = keyword.trim().toLowerCase();
        return books.values()
                .stream()
                .filter(book -> contains(book.getTitle(), normalizedKeyword)
                        || contains(book.getAuthor(), normalizedKeyword)
                        || contains(book.getIsbn(), normalizedKeyword))
                .sorted(Comparator.comparing(Book::getId))
                .toList();
    }

    private boolean contains(String value, String keyword) {
        return value != null && value.toLowerCase().contains(keyword);
    }

    private Book copyOf(Book book) {
        return new Book(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getCopiesAvailable()
        );
    }
}
