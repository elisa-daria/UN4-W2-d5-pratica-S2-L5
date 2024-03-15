package elisadaria;

import com.github.javafaker.Faker;
import elisadaria.entities.Book;
import elisadaria.entities.Magazine;
import elisadaria.enums.Genres;
import elisadaria.enums.TypeOfMag;

import java.util.Locale;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Faker faker=new Faker(Locale.ITALY);

        System.out.println(faker.backToTheFuture().character());
        Book bookA=new Book("JKR", Genres.FANTASY);
        bookA.setTitle(faker.harryPotter().book());
        System.out.println(bookA.getTitle());
        System.out.println(bookA.getCodeISBN());
        System.out.println(bookA.toString());
        Magazine vogue=new Magazine(TypeOfMag.MENSILE);
        vogue.setTitle(faker.buffy().quotes());
        System.out.println(vogue.toString());
    }
}
