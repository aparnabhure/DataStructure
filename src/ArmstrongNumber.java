public class ArmstrongNumber {

    public static void main(String[] args){
        System.out.println(isArmStrong(1634));
    }

    private static boolean isArmStrong(int number){

        int length = 0;
        if(number != 0){
            int tempNumber = number;
            while (tempNumber != 0){
                tempNumber = tempNumber/10;
                length++;
            }

            int sum = 0;
            tempNumber = number;
            for(int i=0; i<length; i++){
                int reminder = tempNumber%10;
                tempNumber = tempNumber/10;
                sum += Math.pow(reminder, length);
            }

            return (sum == number);
        }

        return false;
    }
}
