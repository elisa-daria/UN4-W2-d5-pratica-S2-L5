package elisadaria.entities;

import elisadaria.enums.Genres;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Book extends LibraryElement{
    //attributes
    private String author;
    private Genres genre;

    //constructor
    public Book(String title,String author, Genres genre) {
        super(title);
        this.setAuthor(author);
        this.setGenre(genre);
    }
    //getters

    public String getAuthor() {
        return author;
    }

    public Genres getGenre() {
        return genre;
    }

    //setters

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }

    //methods

    public static void addNewBook(Set<Book> books, String title, String author, Genres genre) {
        books.add(new Book(title, author, genre));
    }
    public static Set<Book> searchByAuthor(Set<Book> books, String authorToSearch) {
        return books.stream()
                .filter(book -> book.getAuthor().equals(authorToSearch))
                .collect(Collectors.toSet());
    }

}
