package elisadaria.entities;

import java.util.Random;

abstract class LibraryElement {
    //attributes
    private long codeISBN;
    private String title;
    private int yearOfPublication;
    private int numberOfPages;

    //constructor

    public LibraryElement() {
        this.setCodeISBN();
        this.setTitle(title);
        this.yearOfPublication = yearOfPublication;
        this.setNumberOfPages();
    }

    //getters

    public long getCodeISBN() {
        return codeISBN;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }


    //setters
    Random rdm=new Random();

    public void setCodeISBN() {
        this.codeISBN = rdm.nextInt(1,1001);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public void setNumberOfPages() {
        this.numberOfPages = rdm.nextInt(1,865);
    }

    //methods

    @Override
    public String toString() {
        return "LibraryElement{" +
                "codeISBN=" + codeISBN +
                ", title='" + title + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
