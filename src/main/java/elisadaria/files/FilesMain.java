package elisadaria.files;

import elisadaria.entities.Book;
import elisadaria.enums.Genres;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FilesMain {
    public static void main(String[] args) {
        File file=new File("src/output.txt");
        Book book= new Book("la mi disfatta mentale e fisica: il Venerdì","ByMe", Genres.HORROR);
        try {
            FileUtils.writeStringToFile(file,book.toString()+System.lineSeparator(), StandardCharsets.UTF_8,true);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Anche questa fatta");
    }
}
