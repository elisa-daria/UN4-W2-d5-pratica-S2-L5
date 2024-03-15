package elisadaria.entities;


import elisadaria.enums.TypeOfMag;

import java.util.List;
import java.util.Set;


public class Magazine extends LibraryElement {
    //attributes
    private TypeOfMag type;
    //constructor
    public Magazine(String title,TypeOfMag type) {
        super(title);
        this.setType(type);
    }
    //getter

    public TypeOfMag getType() {
        return type;
    }

    //setter

    public void setType(TypeOfMag type) {
        this.type = type;
    }

    //methods
    public static void addNewMag(List<Magazine> magazines, String title, TypeOfMag type) {
        magazines.add(new Magazine(title,type));
    }

    public static void removeMagByISBN(List<Magazine> magazines, String isbnToRemove)throws Magazine.MagNotFoundException  {
        boolean removed= magazines.removeIf(book -> book.getCodeISBN().equals(isbnToRemove));
        if(!removed){
            throw new Magazine.MagNotFoundException("Non esiste nessun magazines con questo ISBN: " + isbnToRemove);
        }
    }
    //Eccezione customized
    public static class MagNotFoundException extends Exception {
        public MagNotFoundException(String message) {
            super(message);
        }
    }
}
