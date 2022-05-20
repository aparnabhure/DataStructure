public class FindPerfectSquare {

    public static void main(String[] args) {
        perfectSquares(100);
    }

    //O(sqrt(n))
    static void perfectSquares(int n){
        for(int i=1; i<=n; i++){
            if(i*i>n) break;
            System.out.println(i*i);
        }
    }
}
