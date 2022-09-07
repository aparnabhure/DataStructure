import java.util.Stack;

//https://leetcode.com/problems/maximal-rectangle/
public class MaximalRactangle {

    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][]{{'0','1'},{'1','0'}}));
        System.out.println(maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }

    static int maximalRectangle(char[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[] arr = new int[m];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n; i++){
            for(int j=0; j<m; j++){
                int val = Character.getNumericValue(matrix[i][j]);
                if(val == 0) arr[j] = 0;
                else arr[j] ++;
            }

            //Find max area
            int area = maxArea(arr, m);
            max = Math.max(max, area);
        }

        return max;

    }

    static int maxArea(int[] arr, int n){
        int[] nsl = nslArr(arr, n);
        int[] nsr = nsrArr(arr, n);
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int left = (nsl[i] == -1)?0:nsl[i]+1;
            int right = (nsr[i] == -1)?n-1:nsr[i]-1;
            int area = arr[i]* (right-left+1);
            max = Math.max(area, max);
        }

        return max;
    }

    static int[] nslArr(int[] A, int n){
        int[] nsl = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        nsl[0] = -1;
        for(int i=1; i<n; i++){
            while(!stack.isEmpty() && A[stack.peek()] >= A[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = stack.peek();
            }
            stack.push(i);
        }

        return nsl;
    }

    static int[] nsrArr(int[] A, int n){
        int[] nsr = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);
        nsr[n-1] = -1;
        for(int i=n-2; i>=0; i--){
            while(!stack.isEmpty() && A[stack.peek()] >= A[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nsr[i] = -1;
            }else{
                nsr[i] = stack.peek();
            }
            stack.push(i);
        }

        return nsr;
    }

//    static int maximalRectangle(char[][] matrix) {

//        int n = matrix.length;
//        int m = matrix[0].length;
//
//        int max = Integer.MIN_VALUE;
//        for(int i=0;i<n; i++){
//            int[] arr = new int[m];
//            for(int j=0; j<m; j++){
//                arr[j] += Character.getNumericValue(matrix[i][j]);
//            }
//
//            //Find max area
//            int area = maxArea(arr, m);
//            max = Math.max(max, area);
//        }
//
//        return max;
//
//    }
//
//    static int maxArea(int[] arr, int n){
//        int[] nsl = nslArr(arr, n);
//        int[] nsr = nsrArr(arr, n);
//        int max = Integer.MIN_VALUE;
//        for(int i=0; i<n; i++){
//            int left = (nsl[i] == -1)?0:nsl[i]+1;
//            int right = (nsr[i] == -1)?n-1:nsr[i]-1;
//            int area = arr[i]* (right-left+1);
//            max = Math.max(area, max);
//        }
//
//        return max;
//    }
//
//    static int[] nslArr(int[] A, int n){
//        int[] nsl = new int[n];
//        Stack<Integer> stack = new Stack<>();
//        stack.push(0);
//        nsl[0] = -1;
//        for(int i=1; i<n; i++){
//            while(!stack.isEmpty() && A[stack.peek()] >= A[i]){
//                stack.pop();
//            }
//            if(stack.isEmpty()){
//                nsl[i] = -1;
//            }else{
//                nsl[i] = stack.peek();
//            }
//            stack.push(i);
//        }
//
//        return nsl;
//    }
//
//    static int[] nsrArr(int[] A, int n){
//        int[] nsr = new int[n];
//        Stack<Integer> stack = new Stack<>();
//        stack.push(n-1);
//        nsr[n-1] = -1;
//        for(int i=n-2; i>=0; i--){
//            while(!stack.isEmpty() && A[stack.peek()] >= A[i]){
//                stack.pop();
//            }
//            if(stack.isEmpty()){
//                nsr[i] = -1;
//            }else{
//                nsr[i] = stack.peek();
//            }
//            stack.push(i);
//        }
//
//        return nsr;
//    }
}
