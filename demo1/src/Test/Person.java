package Test;

/**
 * @author Lemon
 * @create 2022-11-05-9:23
 */
public class Person {
    private String name;
    private int id;
    private Animals pet;
    public Person() {
    }

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void setPet(Animals pet) {
        this.pet = pet;
    }

    public Animals getPet() {
        return pet;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", pet=" + pet +
                '}';
    }
}
