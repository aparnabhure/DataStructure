package BirdAssignment;

public class Parrot extends Bird{

    Eat eat;
    Fly fly;

    public Parrot(){
        super("Parrot", COLOR.GREEN, BREED.X);
        eat = EatingFactory.getEating(EatingType.Y);
        fly = FlyFactory.getFlyingType(FlyingType.Y);
    }
    @Override
    public void fly() {
        fly.fly();
    }

    @Override
    public void walk() {

    }

    @Override
    public void eat() {
        eat.eat();
    }
}
