public class SmallestXOR {
    public static void main(String[] args) {
        System.out.println(solve(4, 6));
    }

    static int solve(int A, int B) {
        if(B ==0){
            return 0;
        }

        int x = 0;

        for(int i=31; i>=0 && B >0; i--){
            if((A&(1<<i))>0){
                x += (1<<i);
                B--;
            }
        }


        //Add rest in X;
        for(int i=0; i<32 && B>0;i++){
            if((x & (1<<i))== 0){
                x+= (1<<i);
                B--;
            }
        }


        return x;

    }
}
