package elisadaria;

import com.github.javafaker.Faker;
import elisadaria.entities.Book;
import elisadaria.entities.Magazine;
import elisadaria.enums.Genres;
import elisadaria.enums.TypeOfMag;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Application {
   static Faker faker=new Faker(Locale.ENGLISH);

    public static void main(String[] args) {

        Supplier<Book>hpSupplier=()->{
            return new Book(faker.harryPotter().book(),"JKR",Genres.FANTASY);
        };
        Set<Book> books=new HashSet<>();
        for(int i= 0;i<=7;i++){
            books.add(hpSupplier.get());
        }
        books.stream().collect(Collectors.toSet()).forEach(book -> System.out.println(book));

        Supplier<Magazine>buffySupplier=()->{
            return new Magazine(faker.buffy().quotes(),TypeOfMag.SETTIMANALE);
        };
        List<Magazine>magazines=new ArrayList<>();
        for (int i=0; i<12;i++){
            magazines.add(buffySupplier.get());
        }
        magazines.stream().toList().forEach(mag -> System.out.println(mag));


        Magazine.addNewMag(magazines,faker.rockBand().name(),TypeOfMag.MENSILE);
        try {
            Magazine.removeMagByISBN(magazines,"702");
        } catch (Magazine.MagNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Magazine.searchByISBN(magazines,"102").forEach(mag-> System.out.println(mag));
        } catch (Magazine.MagNotFoundException e) {
            throw new RuntimeException(e);
        }
        Magazine.searchByPublicationYear(magazines,2005);

        Book.addNewBook(books, faker.hitchhikersGuideToTheGalaxy().marvinQuote(),"Douglas Adams",Genres.SCI_FI);
        String authorToSearch = "Douglas Adams";
        Set<Book> booksByAuthor = Book.searchByAuthor(books, authorToSearch);
        System.out.println(booksByAuthor);
        try {
            Book.removeBookByISBN(books,"788");
        } catch (Book.BookNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Book.searchByISBN(books, "203");
        } catch (Book.BookNotFoundException e) {
            throw new RuntimeException(e);
        }
        Book.searchByPublicationYear(books,1997);

        List library= new ArrayList<>();
        library.addAll(books);
        library.addAll(magazines);
        System.out.println("*******************LIBRARY*****************");
        System.out.println(library);


        File libraryFile=new File("src/myLibrary.txt");
        try {
            FileUtils.writeStringToFile(libraryFile,library.toString()+System.lineSeparator(), StandardCharsets.UTF_8,true);
            System.out.println("Saved");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
