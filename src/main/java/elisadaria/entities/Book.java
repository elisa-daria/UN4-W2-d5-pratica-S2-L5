package elisadaria.entities;

import elisadaria.enums.Genres;

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

}
