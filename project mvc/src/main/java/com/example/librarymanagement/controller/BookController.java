package com.example.librarymanagement.controller;

import com.example.librarymanagement.exception.DuplicateIsbnException;
import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.service.BookPage;
import com.example.librarymanagement.service.BookService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String listBooks(@RequestParam(required = false) String keyword,
                            @RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "5") int size,
                            Model model) {
        addPageAttributes(keyword, page, size, model);
        return "books/list";
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam(required = false) String keyword,
                              @RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "5") int size,
                              Model model) {
        addPageAttributes(keyword, page, size, model);
        return "books/list";
    }

    @GetMapping("/api/search")
    @ResponseBody
    public BookPage searchBooksApi(@RequestParam(required = false) String keyword,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "5") int size) {
        return bookService.findPage(keyword, page, size);
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("pageTitle", "Add Book");
        return "books/form";
    }

    @PostMapping
    public String saveBook(@Valid @ModelAttribute Book book,
                           BindingResult bindingResult,
                           Model model,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", book.getId() == null ? "Add Book" : "Edit Book");
            return "books/form";
        }

        try {
            bookService.save(book);
        } catch (DuplicateIsbnException exception) {
            bindingResult.rejectValue("isbn", "duplicate", exception.getMessage());
            model.addAttribute("pageTitle", book.getId() == null ? "Add Book" : "Edit Book");
            return "books/form";
        }

        redirectAttributes.addFlashAttribute("message", "Book saved successfully.");
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("pageTitle", "Edit Book");
        return "books/form";
    }

    @PostMapping("/{id}/delete")
    public String deleteBook(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        bookService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Book deleted successfully.");
        return "redirect:/books";
    }

    @GetMapping("/")
    public String redirectToBooks() {
        return "redirect:/books";
    }

    private void addPageAttributes(String keyword, int page, int size, Model model) {
        BookPage bookPage = bookService.findPage(keyword, page, size);
        model.addAttribute("bookPage", bookPage);
        model.addAttribute("books", bookPage.books());
        model.addAttribute("keyword", keyword);
        model.addAttribute("currentPage", bookPage.currentPage());
        model.addAttribute("pageSize", bookPage.pageSize());
        model.addAttribute("totalPages", bookPage.totalPages());
        model.addAttribute("totalItems", bookPage.totalItems());
    }
}
