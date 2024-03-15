package elisadaria.entities;

import elisadaria.enums.Genres;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Book extends LibraryElement {
    //attributes
    private String author;
    private Genres genre;

    //constructor
    public Book(String title, String author, Genres genre) {
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

    public static void removeBookByISBN(Set<Book> books, String isbnToRemove) throws BookNotFoundException {
        boolean removed = books.removeIf(book -> book.getCodeISBN().equals(isbnToRemove));
        if (!removed) {
            throw new BookNotFoundException("Non esiste nessun libro con questo ISBN: " + isbnToRemove);
        }
    }
    //Eccezione customized
    public static class BookNotFoundException extends Exception {
        public BookNotFoundException(String message) {
            super(message);
        }
    }
    public static Set<Book> searchByISBN(Set<Book> books, String isbnToSearch) throws BookNotFoundException {
        try {
            return books.stream()
                    .filter(book -> book.getCodeISBN().equals(isbnToSearch))
                    .collect(Collectors.toSet());
        } catch (Exception ex) {
            throw new BookNotFoundException(ex.getMessage());
        }
    }
    public static Set<Book> searchByPublicationYear(Set<Book> books, int yearToSearch) {
        return books.stream()
                .filter(book -> book.getYearOfPublication() == yearToSearch)
                .collect(Collectors.toSet());
    }
}
