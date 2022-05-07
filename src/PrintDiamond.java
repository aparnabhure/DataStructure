public class PrintDiamond {
    public static void main(String[] args) {
        printDiamond(4);
    }

    static void printDiamond(int A){
        for(int i=0; i<A; i++){
            for(int j=0;j<A-i;j++){
                System.out.print("*");
            }
            //Space loop
            for(int k=2*i; k>0;k--){
                System.out.print(" ");
            }
            for(int j=0; j<A-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=0; i<A; i++){
            for(int j=i;j>=0;j--){
                System.out.print("*");
            }
            //Space loop
            for(int k=2*(A-1-i); k>0;k--){
                System.out.print(" ");
            }

            for(int j=i;j>=0;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
