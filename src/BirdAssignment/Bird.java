package BirdAssignment;

public abstract class Bird implements BirdActions{
    enum COLOR{
        RED,
        GREEN,
        BLUE,
        BROWN,
        BLACK
    }
    enum BREED{
        X,
        Y,
        Z
    }

    COLOR color;
    BREED breed;
    String name;

    protected Bird(String name, COLOR color, BREED breed){
        this.name = name;
        this.color = color;
        this.breed = breed;
    }

    public COLOR getColor() {
        return color;
    }

    public void setColor(COLOR color) {
        this.color = color;
    }

    public BREED getBreed() {
        return breed;
    }

    public void setBreed(BREED breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
