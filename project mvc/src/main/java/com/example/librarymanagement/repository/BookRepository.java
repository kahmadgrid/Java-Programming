package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.Book;
import org.springframework.stereotype.Repository;

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
        save(new Book(null, "Head First Java", "Kathy Sierra", "9780596009205", 2));
        save(new Book(null, "Java Concurrency in Practice", "Brian Goetz", "9780321349606", 4));
        save(new Book(null, "Design Patterns", "Erich Gamma", "9780201633610", 6));
        save(new Book(null, "Refactoring", "Martin Fowler", "9780134757599", 3));
        save(new Book(null, "Domain-Driven Design", "Eric Evans", "9780321125217", 2));
        save(new Book(null, "The Pragmatic Programmer", "David Thomas", "9780135957059", 5));
        save(new Book(null, "Test Driven Development", "Kent Beck", "9780321146533", 4));
        save(new Book(null, "Working Effectively with Legacy Code", "Michael Feathers", "9780131177055", 1));
        save(new Book(null, "Patterns of Enterprise Application Architecture", "Martin Fowler", "9780321127426", 2));
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

    public Optional<Book> findByIsbn(String isbn) {
        if (isbn == null) {
            return Optional.empty();
        }

        return books.values()
                .stream()
                .filter(book -> isbn.equalsIgnoreCase(book.getIsbn()))
                .findFirst();
    }

    public Book save(Book book) {
        if (book.getId() == null) {
            book.setId(sequence.incrementAndGet());
        }

        book.setIsbn(book.getIsbn().trim());
        book.setTitle(book.getTitle().trim());
        book.setAuthor(book.getAuthor().trim());
        books.put(book.getId(), copyOf(book));
        return book;
    }

    public boolean deleteById(Long id) {
        return books.remove(id) != null;
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
