package BirdAssignment;

public class EatingFactory {
    public static Eat getEating(EatingType eatingType){
        switch (eatingType) {
            case X : return new XEatingType();
            case Y : return new YEatingType();
            default : return null;
        }
    }
}
