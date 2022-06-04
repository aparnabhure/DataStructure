public class PowerRecursive {
    //Calculate pow(A,B)%C for negative nums as well
    public static void main(String[] args) {
        System.out.println(pow(-1, 2, 20));

        System.out.println(pow(-1, 1, 20));
        System.out.println(pow(71045970, 41535484, 64735492));
    }

    static int pow(int A, int B, int C){
        if(A == 0) return 0;
        if(B == 0) return 1;
        if(B == 1) return mod(A, C);
        long X = pow(A, B/2, C);
        long Y = (((X%C)*(X%C))%C);
        if((B&1) == 0){
            return (int) Y;
        }else{
            int a = mod(A, C);
            return (int)((a*Y)%C);

        }
    }

    static int mod(int A, int C){
        return A < 0 ? (A % C) + C : (A % C);
    }

    //            int x= (int)((Long.valueOf(Y%C)*Long.valueOf(A%C))%C);
//            if (x<0){
//                return C+(int)((Long.valueOf(Y%C)*Long.valueOf(A%C))%C);
//            }
//            else{
//                return x;
//            }
}
