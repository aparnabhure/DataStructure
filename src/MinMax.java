import java.util.Arrays;
import java.util.Stack;

//https://www.scaler.com/academy/mentee-dashboard/class/34901/assignment/problems/7042?navref=cl_tt_nv
/*
Given an array of integers A.

value of a array = max(array) - min(array).

Calculate and return the sum of values of all possible subarrays of A modulo 109+7.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 1000000



Input Format
The first and only argument given is the integer array A.



Output Format
Return the sum of values of all possible subarrays of A modulo 109+7.



Example Input
Input 1:

 A = [1]
Input 2:

 A = [4, 7, 3, 8]


Example Output
Output 1:

 0
Output 2:

 26


Example Explanation
Explanation 1:

Only 1 subarray exists. Its value is 0.
Explanation 2:

value ( [4] ) = 4 - 4 = 0
value ( [7] ) = 7 - 7 = 0
value ( [3] ) = 3 - 3 = 0
value ( [8] ) = 8 - 8 = 0
value ( [4, 7] ) = 7 - 4 = 3
value ( [7, 3] ) = 7 - 3 = 4
value ( [3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3] ) = 7 - 3 = 4
value ( [7, 3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3, 8] ) = 8 - 3 = 5
sum of values % 10^9+7 = 26
 */
public class MinMax {
    public static void main(String[] args) {
        //ans 733529849
        System.out.println(solve(new int[]{ 994390, 986616, 976849, 979707, 950477, 968402, 992171, 937674, 933065, 960863, 980981, 937319, 951236, 959547, 991052, 991799, 992213, 941294, 978103, 997198, 960759, 988476, 963517, 980366, 921767, 979757, 977912, 983761, 981869, 947454, 930202, 999086, 973538, 999798, 996446, 944001, 974217, 951595, 942688, 975075, 970973, 970130, 897109, 927660, 862233, 997130, 986068, 954098, 978175, 889682, 988973, 996036, 969675, 985751, 977724, 881538, 988613, 924230, 906475, 915565, 986952, 975702, 994316, 964011, 986848, 983699, 949076, 989673, 981788, 929094, 988310, 926471, 994763, 999736, 980762, 973560, 996622, 934475, 998365, 966255, 998697, 998700, 911868, 983245, 996382, 996992, 953142, 994104, 987303, 853837, 960626, 904203, 998063, 977596, 977868, 996012, 946345, 949255, 988138, 996298, 954933, 965036, 886976, 998628, 990878, 953725, 916744, 985233, 919661, 970903, 986066 }));
        System.out.println(solve(new int[]{992387, 932142, 971117, 934674, 988917, 967890, 948508, 970347 }));//ans 1362057
    }
    static int solve(int[] A) {
        int n = A.length;
        int[] nsl = nslArr(A, n);
        int[] ngl = nglArr(A, n);
        int[] nsr = nsrArr(A, n);
        int[] ngr = ngrArr(A, n);

        int mod = 1000000007;
        long maxSum = 0;
        long minsum = 0;
        for(int i=0; i<n; i++){
            maxSum = (maxSum%mod)+ ((((long) (i - ngl[i]) *(ngr[i]-i))%mod)*A[i])%mod;
            minsum = (minsum%mod) + (((long) (i - nsl[i]) *(nsr[i]-i))%mod*A[i])%mod;
        }

        long ans = ((maxSum-minsum)%mod);
        if (ans < 0) {
            ans = (ans + mod) % mod;
        }

        return (int)(ans%mod);

//        int mod = 1000000007;
//        long ans = 0;
//        for(int i=0; i<n; i++){
//            int p1 = nsl[i];
//            int p2 = nsr[i];
//            long prodMin = ((long) (i - p1) * (p2 - i)) % mod;
//            long minContribution = (prodMin * A[i]) % mod;
//
//            int p3 = ngl[i];
//            int p4 = ngr[i];
//            long prodMax = ((long) (i - p3) * (p4 - i)) % mod;
//            long maxContribution = (prodMax * A[i]) % mod;
//
//            //computing ans
//            ans = (ans % mod) + ((maxContribution - minContribution) % mod);
//            ans = ans % mod;
//        }
//
//        if (ans < 0) {
//            ans = (ans + mod) % mod;
//        }
//
//        return (int)(ans%mod);
    }

    static int[] nglArr(int[] A, int n){
        int[] ngl = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        ngl[0] = -1;
        for(int i=1; i<n; i++){
            while(!stack.isEmpty() && A[i] >= A[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ngl[i] = -1;
            }else{
                ngl[i] = stack.peek();
            }
            stack.push(i);
        }

        return ngl;
    }

    static int[] ngrArr(int[] A, int n){
        int[] ngr = new int[n];
        Arrays.fill(ngr, n); //edge case
        Stack <Integer> stack = new Stack<>();

        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && A[i] >= A[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ngr[i] = stack.peek();
            }
            stack.push(i);
        }
//        Stack<Integer> stack = new Stack<>();
//        stack.push(n);
//        ngr[n-1] = n;
//        for(int i=n-2; i>=0; i--){
//            while(!stack.isEmpty() && A[i] >= A[stack.peek()]){
//                stack.pop();
//            }
//            if(stack.isEmpty()){
//                ngr[i] = n;
//            }else{
//                ngr[i] = stack.peek();
//            }
//            stack.push(i);
//        }
        return ngr;
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
        Arrays.fill(nsr, n); //edge case
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[i] <= A[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nsr[i] = stack.peek();
            }
            stack.push(i);
        }
//        Stack<Integer> stack = new Stack<>();
//        stack.push(n);
//        nsr[n-1] = n;
//        for(int i=n-2; i>=0; i--){
//            while(!stack.isEmpty() && A[stack.peek()] >= A[i]){
//                stack.pop();
//            }
//            if(stack.isEmpty()){
//                nsr[i] = n;
//            }else{
//                nsr[i] = stack.peek();
//            }
//            stack.push(i);
//        }

        return nsr;
    }


    private static int[] prevSmallerIndex(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        Stack < Integer > stack = new Stack < > ();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[i] <= A[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    private static int[] nextSmallerIndex(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        Arrays.fill(ans, N); //edge case
        Stack < Integer > stack = new Stack < > ();

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[i] <= A[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    private static int[] prevGreaterIndex(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        Stack < Integer > stack = new Stack < > ();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[i] >= A[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    private static int[] nextGreaterIndex(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        Arrays.fill(ans, N); //edge case
        Stack <Integer> stack = new Stack<>();

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[i] >= A[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }
}
