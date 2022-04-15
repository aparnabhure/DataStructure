package BirdAssignment;

public class FlyFactory {
    public static Fly getFlyingType(FlyingType type){
         switch (type) {
            case X : return new XFlyingType();
             case Y : return new YFlyingType();
             default : return null;
        }
    }
}
