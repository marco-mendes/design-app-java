package com.exemplo;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookService {


    private List<Book> bookDatabase;

    public BookService() {
        this.initBookDatabase();
    }

    public List<Book> getAllBooks() {
        return this.bookDatabase;
    }

    // Get
    public Book getBookById(int id) {
        return this.bookDatabase.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .get();
    }

    // Post
    public void addBook(Book book) {
        this.bookDatabase.add(book);
    }

    // Put
    public void updateBook(int id, Book book) {
        Book bookToUpdate = this.getBookById(id);
        int indexOfBook = this.bookDatabase.indexOf(bookToUpdate);
        this.bookDatabase.set(indexOfBook, book);
    }

    // Delete
    public void removeBook(int id) {
        Book book = this.getBookById(id);
        this.bookDatabase.remove(book);
    }

    private void initBookDatabase() {
        this.bookDatabase = new ArrayList<>();
        this.bookDatabase.add(new Book(1, "Padrões de Projeto", "Erich Gamma"));
        this.bookDatabase.add(new Book(2, "Java 8 Lambdas", "Richard Warburton"));
        this.bookDatabase.add(new Book(3, "Métricas Ágeis", "Raphael Albino"));
        this.bookDatabase.add(new Book(4, "Java EE", "Alberto Souza"));
        this.bookDatabase.add(new Book(5, "Vire o jogo com Spring Framework", "Henrique Lobo Weissmann"));
    }

}
