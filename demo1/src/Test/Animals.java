package Test;

/**
 * @author Lemon
 * @create 2022-11-05-10:46
 */
public class Animals {
    private String species;
    private String name;

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animals{" +
                "species='" + species + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
