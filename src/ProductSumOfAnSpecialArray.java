import java.util.List;

/**
 * [5,2,[7,-1],3,[6,[-13,8],4]]
 * ans 12
 * product is the depth of the special array, initially it would be 1
 *
 *  5+2+ 2*(7-1) + 3 + 2*(6+ 3*(-13+8) +4)
 *  5+2+12+3+2*(6-15+4)
 *  5+2+12+3-10 = 12
 *
 */
public class ProductSumOfAnSpecialArray {
    public static void main(String[] args) {
        Object[] specialArray =new Object[]{5,2,new Object[]{7,-1},3,new Object[]{6,new Object[]{-13,8},4}};
        System.out.println(productSum(specialArray, 1));
    }

    //O(n) N is total items in the array
    private static int productSum(Object[] specialArray, int depth){
        int sum =0;
        for(Object obj:specialArray) {
            if (obj instanceof Integer) {
                sum += (Integer)obj;
            }else {
                sum+= productSum((Object[])obj, depth+1);
            }
        }
        return depth*sum;
    }
}
