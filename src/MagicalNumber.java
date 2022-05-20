//Find magical number of Nth term, magical number is a number which can be written in sum of unique power of 5
// Nth term = 5^1 + 5^2 ...
public class MagicalNumber {
    /*                            4 3 2 1 (powers)
    1st term = 5^1 = 5            0 0 0 1 = 1
    2nd      = 5^2 = 25           0 0 1 0 = 2
    3rd      = 5^2 + 5^1          0 0 1 1 = 3
    4        = 5^3                0 1 0 0 = 4

    to calculate Nth term generate the binary number and do the sum with 5 power where the bits are set
     */

    public static void main(String[] args) {
        for(int i=1; i<10; i++){
            System.out.println(magicalNumber(i));
        }
    }

    static long magicalNumber(int term){
        int pow = 1;
        long sum = 0;
        while(term>0){
            if((term&1) == 1){
                sum += Math.pow(5, pow);
            }

            term = term>>1;
            pow++;
        }

        return sum;

    }
}
