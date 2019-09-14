/**
 * Suppose you have N eggs and you want to determine from which floor in a K-floor building you can drop an egg such that it doesn't break. You have to determine the minimum number of attempts you need in order find the critical floor in the worst case while using the best strategy.There are few rules given below.
 *
 * An egg that survives a fall can be used again.
 * A broken egg must be discarded.
 * The effect of a fall is the same for all eggs.
 * If the egg doesn't break at a certain floor, it will not break at any floor below.
 * If the eggs breaks at a certain floor, it will break at any floor above.
 * For more description on this problem see wiki page
 *
 * Input:
 * The first line of input is  T denoting the number of testcases.Then each of the T lines contains two positive integer N and K where 'N' is the number of eggs and 'K' is number of floor in building.
 *
 * Output:
 * For each test case, print a single line containing one integer the minimum number of attempt you need in order find the critical floor.
 *
 * Constraints:
 * 1<=T<=30
 * 1<=N<=10
 * 1<=K<=50
 *
 * Example:
 * Input:
 * 2
 * 2 10
 * 3 5
 *
 * Output:
 * 4
 * 3
 *
 * Use dynamic programming
 *
 * Formula:
 * if(eggs > floors)
 * matrix[eggs][floors] = matrix[eggs-1][floors]
 * else
 * matrix[eggs][floors] = 1 + min( max(matrix[eggs-1][k-1], matrix[eggs][floors-k]))
 * where k 1 to floors
 *
 */
public class EggDropProblem {
    public static void main(String[] args){
        findMinAttempt(6, 2);
        System.out.println();
        findMinAttempt(10, 2);
        System.out.println();
        findMinAttempt(10, 3);
    }

    private static void findMinAttempt(int floors, int eggs){
        int[][] matrix = new int[eggs+1][floors+1];

        //Fill the array considering brute force for 1 egg and try to drop eggs from each floor so the number of attempts = number of floors
        for(int floor = 1; floor<=floors; floor++){
            matrix[1][floor] = floor;
        }

        for(int egg=2; egg<= eggs; egg++){
            for(int floor=1; floor<=floors; floor++){
                matrix[egg][floor] = Integer.MAX_VALUE;
                for(int k=1; k<=floor; k++) {
                    int breakAttempt = matrix[egg - 1][k - 1];
                    int notBreaksAttempt = matrix[egg][floor - k];
                    int floorAttempt = 1 + Math.max(breakAttempt, notBreaksAttempt);
                    if(floorAttempt < matrix[egg][floor]){
                        matrix[egg][floor] = floorAttempt;
                    }
                }
            }
        }

        printMatrix(matrix, eggs, floors);
        System.out.println(String.format("Minimum %d attempts required for %d floors with %d eggs", matrix[eggs][floors], floors, eggs));
    }


    private static void printMatrix(int[][] matrix, int iLength, int jLength){
        for(int e=0; e<=iLength; e++){
            System.out.println();
            for(int f=0; f<=jLength; f++){
                System.out.print(" " + matrix[e][f] + " ");
            }
        }
        System.out.println();
    }
}
