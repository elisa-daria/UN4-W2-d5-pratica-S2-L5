package elisadaria;

import com.github.javafaker.Faker;
import elisadaria.entities.Book;
import elisadaria.entities.Magazine;
import elisadaria.enums.Genres;
import elisadaria.enums.TypeOfMag;


import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Application {
   static Faker faker=new Faker(Locale.ENGLISH);

    public static void main(String[] args) {
        Supplier<Book>hpSupplier=()->{
            return new Book(faker.harryPotter().book(),"JKR",Genres.FANTASY);
        };
        Set<Book> hpSet=new HashSet<>();
        for(int i= 0;i<=7;i++){
            hpSet.add(hpSupplier.get());
        }
        hpSet.stream().collect(Collectors.toSet()).forEach(book -> System.out.println(book));

        Supplier<Magazine>buffySupplier=()->{
            return new Magazine(faker.buffy().quotes(),TypeOfMag.SETTIMANALE);
        };
        List<Magazine>buffyComics=new ArrayList<>();
        for (int i=0; i<12;i++){
            buffyComics.add(buffySupplier.get());
        }
        buffyComics.stream().toList().forEach(mag -> System.out.println(mag));
    }
}
