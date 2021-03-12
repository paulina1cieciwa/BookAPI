package pl.bookapi.beans.model;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> getBooks();
    public Book add(Book book);
    public Optional<Book> get(Long id);
    public void delete(Long id);
    public void update(Book book);


}
