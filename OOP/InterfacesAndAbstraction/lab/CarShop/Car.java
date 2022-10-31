package InterfacesAndAbstraction.lab.CarShop;

import java.io.Serializable;

public interface Car extends Serializable {

    public static final Integer TIRES = 4; // every field in interface is public static and final

    public abstract String getModel(); //methods are public and abstract without body or public and static with body

    String getColor();
    Integer getHorsePower();
    String countryProduced();




}
