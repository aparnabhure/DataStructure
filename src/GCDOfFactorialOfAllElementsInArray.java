public class GCDOfFactorialOfAllElementsInArray {
    public static void main(String[] args) {
        System.out.println(findGcd(new int[]{4,8,6}));
        System.out.println(findGcd(new int[]{4,3,8,6}));
    }

    //TC: O(n+k) where k is the min element SC : O(k)
    static int findGcd(int[] A){
        //Min element in array would have the common factorial GCD
        int n = A.length;
        int min = Integer.MAX_VALUE;
        for(int a:A){
            min =Math.min(min, a);
        }

        if(min == 0) return 1;

        return factorial(min);
    }

    static int factorial(int min){
        if(min ==1) return 1;
        return min*factorial(min-1);
    }
}
