//https://leetcode.com/problems/sum-of-all-subset-xor-totals/
public class SumXOROfAllSubsets {
    public static void main(String[] args) {


        int MSB = (int)(Math.log(5)/Math.log(2)); // finding the Most Significant Bit position of num
        int mask = ((1<<MSB)|((1<<MSB)-1)); // creating a mask like - 00..MSB..11111. So all zeroes till MSB and MSB and afterwards it is all ones.
        System.out.println((5^mask)); // now we can simply xor it - which is used as an inverter of bits


        int[] A = new int[]{1,3};
        System.out.println(sum(A, 0, 0));
        A = new int[]{5,1,6};
        System.out.println(sum(A, 0, 0));
    }

    static int sum(int[] A, int currentIndex, int xor){
        if(currentIndex==A.length) {
            return xor;
        }
        int consider=sum(A,currentIndex+1,xor^A[currentIndex]);
        int notconsider=sum(A,currentIndex+1,xor);

        return consider  + notconsider;
    }
}
