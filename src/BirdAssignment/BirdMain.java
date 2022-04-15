package BirdAssignment;

//Assignment Design a System to handle Birds
public class BirdMain {
    public static void main(String[] args) {
        Bird bird = new Eagle();
        System.out.println(bird.getName() +" "+bird.getColor() + " " + bird.getBreed());
        bird.fly();
        bird.eat();

        System.out.println("********************");
        bird = new Hen();
        System.out.println(bird.getName() +" "+bird.getColor() + " " + bird.getBreed());
        bird.fly();
        bird.eat();

        System.out.println("********************");
        bird = new Parrot();
        System.out.println(bird.getName() +" "+bird.getColor() + " " + bird.getBreed());
        bird.fly();
        bird.eat();

        System.out.println("********************");
        bird = new Pigeon();
        System.out.println(bird.getName() +" "+bird.getColor() + " " + bird.getBreed());
        bird.fly();
        bird.eat();
    }
}
