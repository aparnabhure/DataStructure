public class SubArrayMinAverage {
    public static void main(String[] args) {
        int[] A = new int[]{3, 7, 90, 20, 10, 50, 40};
        int B = 3;
        System.out.println(solve(A, B));
        A = new int[]{3, 7, 5, 20, -10, 0, 12};
        B = 2;
        System.out.println(solve(A, B));
        A = new int[]{9, 1, 17, 15, 19, 3, 8, 5};
        B = 6;
        System.out.println(solve(A, B));
        A = new int[]{15, 7, 11, 7, 9, 8, 18, 1, 16, 18, 6, 1, 1, 4, 18};
        B = 6;
        System.out.println(solve(A, B));
    }

    static int solve(int[] A, int B){
        int len = A.length;
        if(len <= 0 || B > len || B == 0){
            return 0;
        }

        int counter = 0;
        double currentAverage = 0;
        double minAverage = Double.MAX_VALUE;
        int minAvgIndex = -1;

        for(int i=0; i<len; i++){
            counter++;
            currentAverage += A[i];
            if(counter == B){
                double avg = currentAverage/B;
                if(avg < minAverage){
                    minAverage = avg;
                    minAvgIndex = i+1-B;
                }
                counter--;
                currentAverage -= A[i+1-B];
            }
        }

        return minAvgIndex;
    }
}
