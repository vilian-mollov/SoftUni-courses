package Exam_19_February_2022.parrots;

public class Parrot {

    //name: String
    //species: String
    //available: boolean - true by default

    private String name;
    private String species;
    private boolean available = true;

    public Parrot(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(){
        this.available = false;
    }

    @Override
    public String toString() {
        return String.format("Parrot (%s): %s",species,name);
    }
}
