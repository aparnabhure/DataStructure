public class ClosetMinMax {
    public static void main(String[] args) {
        int[] A = new int[]{814, 761, 697, 483, 981};
        System.out.println(solve(A));
        A = new int[]{0, 2, 1, 1, 3, 2, 3, 1, 0, 1, 2, 3};
        System.out.println(solve(A));
        A = new int[]{343, 291, 963, 165, 152};
        System.out.println(solve(A));

    }

    static int solve(int[] A){
        int len = A.length;
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return 1;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i =0; i<len;i++){
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }
        if(min == max){
            return 1;
        }

        int minIndex = -1;
        int maxIndex = -1;
        int ans = len;
        for(int i=0; i<len; i++){
            if(A[i] == min){
                //Find max
                minIndex = i;
                if(maxIndex != -1){
                    int subarray;
                    if(maxIndex>minIndex){
                        subarray = maxIndex-minIndex+1;
                    }else{
                        subarray = minIndex-maxIndex+1;
                    }
                    ans = Math.min(ans, subarray);
                }
            }else if(A[i] == max){
                //Find min
                maxIndex = i;
                if(minIndex != -1 ){
                    int subarray;
                    if(maxIndex>minIndex){
                        subarray = maxIndex-minIndex+1;
                    }else{
                        subarray = minIndex-maxIndex+1;
                    }
                    ans = Math.min(ans, subarray);
                }
            }


        }
        return ans;
    }
}
