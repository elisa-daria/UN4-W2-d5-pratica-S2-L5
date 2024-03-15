package elisadaria.entities;


import elisadaria.enums.TypeOfMag;

public class Magazine extends LibraryElement {
    //attributes
    private TypeOfMag type;
    //constructor
    public Magazine(TypeOfMag type) {
        super();
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
}
