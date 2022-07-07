/*
Find next largest number
Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.

If such arrangement is not possible, it must be rearranged as the lowest possible order, i.e., sorted in ascending order.

1 <= N <= 5 * 105

1 <= A[i] <= 109



Input Format
The first and the only argument of input has an array of integers, A.



Output Format
Return an array of integers, representing the next permutation of the given array.



Example Input
Input 1:

 A = [1, 2, 3]
Input 2:

 A = [3, 2, 1]


Example Output
Output 1:

 [1, 3, 2]
Output 2:

 [1, 2, 3]


Example Explanation
Explanation 1:

 Next permutaion of [1, 2, 3] will be [1, 3, 2].
Explanation 2:

 No arrangement is possible such that the number are arranged into the numerically next greater permutation of numbers.
 So will rearranges it in the lowest possible order.
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] A = nextPermutation(new int[]{1,2,3});
        print(A);
        A = nextPermutation(new int[]{1,3,5,4,2});
        print(A);
        A = nextPermutation(new int[]{5,4,3,2,1});
        print(A);
    }

    static void print(int[] A){
        for(int i:A){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    //TC O(n) SC O(1)
    //https://www.youtube.com/watch?v=LuLCLgMElus
    static int[] nextPermutation(int[] A) {
        //Find the number from back which is greater than i+1, then find the next greater number which is greater then first number
        //swap both numbers and then reverse whole array from i+1 position to end
        int n = A.length;
        if(n == 1){
            return A;
        }
        //Find element grater from back
        int i = n-2;
        while(i>=0 && A[i] >= A[i+1]) i--;

        //Found the greater number from back, now find the next grater number
        if(i>=0){
            int j= n-1;
            while(j>=0 && A[j]<=A[i])j--;
            //Swap the i & j elements
            swap(A, i, j);
        }

        //Reverse the array from i+1 to end
        reverse(A, i+1, n-1);


        return A;
    }

    static void reverse(int[] A, int start, int end){
        //Two pointer approach
        while (start < end){
            swap(A, start, end);
            start++;
            end--;
        }
    }

    static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
