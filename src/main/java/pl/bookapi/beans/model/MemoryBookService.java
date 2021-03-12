package pl.bookapi.beans.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MemoryBookService implements BookService {

    private List<Book> books;
    private static Long id = 3L;


    public MemoryBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "92928938293", "ABC", "EFG", "Hijkl", "fantasy"));
        books.add(new Book(2L, "99384938430", "NBV", "HSJHSJHA", "Hijkl", "fantasy"));

    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    @Override
    public Book add(Book book) {
        book.setId(id);
        books.add(book);
        id +=1;
        return book;
    }

    @Override
    public Optional<Book> get(Long id) {
        return books.stream().filter(book-> book.getId()
                .equals(id)).findFirst();
    }

    @Override
    public void delete(Long id) {
        if (get(id).isPresent()){
            books.remove(this.get(id).get());
        }
    }

    @Override
    public void update(Book book) {
        Book bookToUpdate = get(book.getId()).orElse(null);
        if (bookToUpdate != null){
            bookToUpdate.setIsbn(book.getIsbn());
            bookToUpdate.setTitle(book.getTitle());
            bookToUpdate.setAuthor(book.getAuthor());
            bookToUpdate.setPublisher(book.getPublisher());
            bookToUpdate.setType(book.getType());
        }
    }

}
