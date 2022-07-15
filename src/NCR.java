public class NCR {
    //Calculate nCr %M
    public static void main(String[] args) {
        System.out.println(ncr(5,2,13));

        System.out.println(solve(3985,574,92867));
        System.out.println(ncp(3985,574,92867));

        System.out.println(solve(4,2,16519));
        System.out.println(ncp(4,2,16519));

        System.out.println(solve(1673,806,80471));
        System.out.println(ncp(1673,806,80471));

        System.out.println(solve(5,2,13));
        System.out.println(ncp(5,2,13));
    }

    //If C is not prime
    static int ncr(int A, int B, int C){
        int[][] ans = new int[A+1][B+1];
        ans[0][0] = 1;

        for(int i=1; i<=A; i++){
            for(int j=0; j<=B; j++){
                if(j==0) ans[i][j]=1;
                else
                ans[i][j] = ((ans[i-1][j-1]%C)+ans[i-1][j]%C)%C;
            }
        }

        return ans[A][B]%C;
    }

    //If C is Prime using inverse mode approach
    // NcR = !n / !n-r * !r = !n %C * ((!n-r)^-1)%C * ((!r)^-1)%C
    static int ncp(int A, int B, int C){
        long n = 1;
        long nr = 1;
        long r =1;
        for(int i=1; i<=A; i++){
            n = (n*i)%C;
            if(i == B){
                r = n;
            }
            if(i == (A-B)){
                nr = n;
            }
        }

        // !n %C
        long x = n;
        //((!n-r)^-1)%C = inverse mode //formula A^-1 = A^M-2 (mod M);
        long y = fastPower((int)nr, C-2, C)%C;
        //((!r)^-1)%C = inverse mode //formula A^-1 = A^M-2 (mod M);
        long z = fastPower((int)r, C-2, C)%C;
        return (int)(((x*y)%C*z)%C);
    }

    static int solve(int A, int B, int C) {
        long result;
        if (B>A) return 0;

        long n=1,nr=1,r=1;
        for (int i=1;i<=A;i++)
        {
            n=(n*i)%C;
            if (i==B)
                r=n;
            if (i==A-B)
                nr=n;
        }
        long val1=fastPower((int)r,C-2,C)%C;
        long val2=fastPower((int)nr,C-2,C)%C;
        result=((n*val1)%C*val2)%C;
        return (int) result;
    }

    static  long fastPower(int A, int pow, int mod){
        if(pow == 0)return 1;

        long p = fastPower(A, pow/2, mod) %mod;
        p = (p*p)%mod;
        if(pow%2 == 0){
            return p;
        }

        return (A*p)%mod;
    }
}
