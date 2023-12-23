package lab3;

import java.util.Arrays;
import java.util.Objects;

public abstract class Person implements Dreamable {
    private final String name;
    private double energy = 100;
    private final Character character;

    public Person(String name, Character character){
        this.name = name;
        this.character = character;
    }

    public void eat(Table table){
        System.out.println(this.name + " eats with  " + Arrays.deepToString(table.getSeaters()));
        this.addEnergy(table.getFood());
    }

    public void dream(Dreamable subject, String action){
        System.out.println(this.name + " dreams about: " + subject.toString() + " " + action);
        this.addEnergy(-0.01);
    }

    public void dream(Dreamable subject, Placeable action, Place place){
        System.out.println(this.name + " dreams about: ");
        action.putIn((Person) subject, place);
        this.addEnergy(-0.01);
    }

    public void beIn(Place place){
        System.out.println(this.name + " spending time in " + place.toString());
    }

    public void talk(String phrase){
        System.out.println(this.name + " says: " + phrase);
        this.addEnergy(-0.01);
    }

    public Character getCharacter() {
        return this.character;
    }

    public String getName() {
        return this.name;
    }

    public void addEnergy(double add) {
        if (this.energy + add <= 0){
            this.energy = 0.0;
        } else {
            this.energy = (this.energy + add) % 100;
        }
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (!(otherObject instanceof Person other)) return false;
        return Double.compare(this.energy, other.energy) == 0 && Objects.equals(this.name, other.name)
                && this.character == other.character;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.energy, this.character);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
