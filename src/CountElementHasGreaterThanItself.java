public class CountElementHasGreaterThanItself {
    //Logic: Find max element counts and minus that count
    // from the total length of the array because rest all elements would always be less than max element
    public static void main(String[] args) {
        int[] A = new int[]{-1,2,4,6,3,6,1};
        System.out.println(countElements(A));
    }

    static int countElements(int[] A){
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<A.length; i++){
            int current = A[i];
            if(max <= current){
                if(max == current){
                    count++;
                }else {
                    count = 1;
                }
                max = current;
            }
        }
        return A.length-count;
    }
}
