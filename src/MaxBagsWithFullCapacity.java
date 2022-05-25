import java.util.Arrays;

//https://leetcode.com/contest/weekly-contest-294/problems/maximum-bags-with-full-capacity-of-rocks/
public class MaxBagsWithFullCapacity {
    public static void main(String[] args) {
        int[] capacity = new int[]{54,18,91,49,51,45,58,54,47,91,90,20,85,20,90,49,10,84,59,29,40,9,100,1,64,71,30,46,91};
        int[] rocks = new int[]   {14,13,16,44, 8,20,51,15,46,76,51,20,77,13,14,35, 6,34,34,13, 3,8,  1,1,61, 5, 2,15,18};
        int additionalRocks = 77;

        System.out.println(maximumBags(capacity, rocks, additionalRocks));

        capacity = new int[]{2,3,4,5};
        rocks = new int[]{1,2,4,4};
        additionalRocks = 2;

        System.out.println(maximumBags(capacity, rocks, additionalRocks));
    }
    static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] temp = new int[n];

        for(int i=0; i<n; i++){
            temp[i] = capacity[i]-rocks[i];
        }

        Arrays.sort(temp);
        int count = 0;
        for(int i=0; i<n; i++){
            int capLeft = temp[i];
            if(capLeft != 0 && additionalRocks>=capLeft){
                additionalRocks -= capLeft;
                capLeft = 0;
            }

            if(capLeft == 0){
                count++;
            }
        }

        return count;

    }
}
