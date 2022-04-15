package BirdAssignment;

public class Eagle extends Bird{

    Eat eat;
    Fly fly;

    public Eagle(){
        super("Eagle", COLOR.BLACK, BREED.Y);
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
