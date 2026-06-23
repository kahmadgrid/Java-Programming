package com.example.librarymanagement.service;

import com.example.librarymanagement.model.Book;

import java.util.List;

public record BookPage(
        List<Book> books,
        int currentPage,
        int pageSize,
        int totalPages,
        int totalItems,
        String keyword
) {

    public boolean hasPrevious() {
        return currentPage > 0;
    }

    public boolean hasNext() {
        return currentPage + 1 < totalPages;
    }
}
