package BirdAssignment;

public class Pigeon extends Bird{
    Eat eat;
    Fly fly;

    public Pigeon(){
        super("Pigeon", COLOR.BLUE, BREED.X);
        eat = EatingFactory.getEating(EatingType.X);
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
