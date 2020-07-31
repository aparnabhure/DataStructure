public class MaxSumFromIntegerPair {
    public static void main(String[] args) {

        //Sliding window approach
        int[] array = new int[]{-3, 2, -1, 10};
        //pairs would be {-3}, {2}, {-1}, {10}, {-3,2}, {2, -1}, {-1, 10}, {-3, 2, -1}, {2, -1, 10}, {-3, 2, -1,10}
        //Ans: 11 {2, -1, 10}
        int maxSum = -10000;
        for(int slide=1; slide<=array.length; slide++){
            for(int i=0; i<=array.length-slide; i++){
                int sum = 0;
                for(int j=i; j<i+slide; j++){
                    sum +=  array[j];
                }
                //System.out.println(sum);
                maxSum = Math.max(sum, maxSum);
            }
        }

        System.out.println("Max Sum "+ maxSum);
    }
}
