//https://leetcode.com/contest/weekly-contest-300/problems/number-of-people-aware-of-a-secret/
public class PeopleKnowSecret {
    public static void main(String[] args) {
        System.out.println(peopleAwareOfSecret(425,81,118));//ans 1754995
        System.out.println(peopleAwareOfSecret(4,1,3));//ans 6
        System.out.println(peopleAwareOfSecret(6, 2, 4));//ans 5
    }

    static int peopleAwareOfSecret(int n, int delay, int forget) {
        if(forget <= delay) return 0;
        //DP approach
        long[] dp = new long[n+1];
        dp[1] = 1;
        long noOfPeopleSharingSecrets = 0;
        int mod = 1000000007;

        for(int i = 2; i<=n; i++){
            //Formula = noOfPeopleSharingSecrets + noOfNewPeopleSharingSecrtes - noOfPeopleForgetting
            int d = i-delay;
            int f = i-forget;
            noOfPeopleSharingSecrets +=  (d>=0?dp[d]%mod:0) -(f>0?dp[f]%mod:0);
            dp[i] = noOfPeopleSharingSecrets;
        }

        long sum = 0;
        for(int i=n-forget+1; i<=n; i++){
            sum = sum%mod + dp[i]%mod;
        }

        return (int)sum%mod;

    }

    static class Person{
        int delay;
        int forget;

        public Person(){}
        public Person(int delay, int forget){
            this.delay=delay; this.forget = forget;
        }
    }
}
