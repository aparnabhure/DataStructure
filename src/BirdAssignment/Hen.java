package BirdAssignment;

public class Hen extends Bird{
    Eat eat;
    Fly fly;

    public Hen(){
        super("Hen", COLOR.RED, BREED.Y);
        eat = EatingFactory.getEating(EatingType.X);
        fly = FlyFactory.getFlyingType(FlyingType.X);
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
