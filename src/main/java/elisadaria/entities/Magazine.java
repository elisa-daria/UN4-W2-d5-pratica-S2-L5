package elisadaria.entities;


import elisadaria.enums.TypeOfMag;

import java.util.List;


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
}
