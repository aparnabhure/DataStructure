//Given an array, find the majority element, majority element is a element whose frequency is > n/2
//there would always be 1 majority element
//Moor's algorithm
public class MajorityElement {
    public static void main(String[] args) {
        int[] A = new int[]{2,3,2,2,4,3,5};
        System.out.println(majorityElement(A));
        A = new int[]{2,2,2,2,4,3,5};
        System.out.println(majorityElement(A));
    }

    //TC: O(n) SC: O(1)
    static int majorityElement(int[] nums){
        int n = nums.length;
        int count = 1;
        int majority = nums[0];
        for(int i=1; i<n; i++){
            if(count == 0){
                majority = nums[i];
                count = 1;
            }else if(majority != nums[i]){
                count = count>0?count-1:0;
            }else{
                count++;
            }
        }

        count = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == majority){
                count++;
            }
        }
        return count>(n/2)?majority:-1;
    }
}
