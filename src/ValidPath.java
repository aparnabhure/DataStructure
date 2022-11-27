/*
There is a rectangle with left bottom as (0, 0) and right up as (x, y).

There are N circles such that their centers are inside the rectangle.

Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.

Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.



Problem Constraints

0 <= x , y, R <= 100

1 <= N <= 1000

Center of each circle would lie within the grid



Input Format

1st argument given is an Integer x , denoted by A in input.

2nd argument given is an Integer y, denoted by B in input.

3rd argument given is an Integer N, number of circles, denoted by C in input.

4th argument given is an Integer R, radius of each circle, denoted by D in input.

5th argument given is an Array A of size N, denoted by E in input, where A[i] = x cordinate of ith circle

6th argument given is an Array B of size N, denoted by F in input, where B[i] = y cordinate of ith circle



Output Format

Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).



Example Input

Input 1:

 x = 2
 y = 3
 N = 1
 R = 1
 A = [2]
 B = [3]

Input 2:

 x = 1
 y = 1
 N = 1
 R = 1
 A = [1]
 B = [1]



Example Output

Output 1:

 NO

Output 2:

 NO



 */
public class ValidPath {
    public static void main(String[] args) {
        System.out.println(solve(0, 91, 3, 5,new int[]{0,0,0}, new int[]{20,21,43}));

        System.out.println(solve(2,3,1,1,new int[]{2}, new int[]{3}));
        System.out.println(solve(4,4,3,1,new int[]{1,0,3}, new int[]{3,2,1}));
    }

    static int[][] dp;
    static boolean[][] visited;
    static String solve(int A, int B, int C, int D, int[] E, int[] F) {

        dp =new int[A+1][B+1];
        visited = new boolean[A+1][B+1];

        //Mark circle points to 1 from 0,0 to x,y (A,B)
        for(int i=0; i<=A; i++){
            for(int j=0; j<=B; j++){
                dp[i][j] = 1;
                for(int k=0; k<C; k++){
                    int distance = (int)(Math.pow(i-E[k], 2) + Math.pow(j-F[k],2));
                    if(distance <= D*D){
                        dp[i][j]=0;
                        break;
                    }
                }
            }
        }

        if(dp[0][0] == 0 || dp[A][B] == 0) return "NO";

        dfs(A, B, 0, 0);

        return visited[A][B]?"YES":"NO";
    }

    static void dfs(int A, int B, int row, int col){
        if(visited[row][col]) return;
        visited[row][col]= true;
        //Check for 8 directions
        for(int dx=-1;dx<=1;dx++){
            for(int dy=-1;dy<=1;dy++){
                int r = row+dx;
                int c = col+dy;
                if(isValidPoint(r, c, A+1, B+1)){
                    dfs(A, B, r, c);
                }
            }
        }
    }

    static boolean isValidPoint(int x, int y, int n, int m){
        return x >= 0 && x < n && y >= 0 && y < m && dp[x][y] != 0;
    }
}
