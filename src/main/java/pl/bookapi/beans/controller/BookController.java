package pl.bookapi.beans.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.bookapi.beans.model.Book;
import pl.bookapi.beans.model.BookService;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public @ResponseBody
    List<Book> getList() {
        return bookService.getBooks();
    }

    @PostMapping("")
    public Book addBook(@RequestBody Book book){
        return bookService.add(book);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return this.bookService.get(id).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        });
    }


    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable Long id){
        bookService.delete(id);
    }

    @PutMapping("")
    public void update(@RequestBody Book book) {
        bookService.update(book);
    }
}
