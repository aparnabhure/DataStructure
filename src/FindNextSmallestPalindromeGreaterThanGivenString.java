public class FindNextSmallestPalindromeGreaterThanGivenString {
    //Constraint 1<=A.length<=100 ( need to find solution in log n or n/2

    static String smalledPal(String A){
        int len = A.length();
        if(len == 1){
            return "11";
        }

        int mid = len/2;
        int left = mid-1;
        int right = mid+1;
        if(len%2 == 0){
            mid--;
            left=mid;
            right = mid+1;
        }
        //Fetch valid left and right pointers to do the comparison example it is needed for numbers like 2385665811c where 856658 is already palindrome
        while(left>=0){
            if(A.charAt(left) == A.charAt(right)){
                //Do nothing, move forward to compare next element
                left--;
                right++;
            }else {
                break;
            }
        }

        if(left>=0 && A.charAt(left)>A.charAt(right)){
            //Copy everything from left to right in reverse order
            return generateString(len, Character.getNumericValue(A.charAt(mid)), A.substring(0, len%2==0?mid+1:mid));
        }else{
            //When left is smaller than right or all characters are same in the string then add +1 in middle element
            int middleElement = Character.getNumericValue(A.charAt(mid));
            middleElement++;
            int carry = middleElement/10;
            left = len%2==0?mid-1:mid;
            StringBuilder carryStr = new StringBuilder();
            carryStr.append(middleElement%10);
            while(left>=0){
                int num = Character.getNumericValue(A.charAt(left));
                num += carry;
                carryStr.insert(0, num%10);
                carry = num/10;
                if(carry == 0){
                    break;
                }
                left--;
            }
            if(left>0) {
                carryStr.insert(0, A.substring(0, left));
            }

            if(carry == 1){
                //This is special case for 99, 999, 9999 type of string
                StringBuilder nineStr = new StringBuilder();
                nineStr.append(carry);
                for(int i=0; i<A.length()-1;i++){
                    nineStr.append("0");
                }
                nineStr.append(carry);
                return nineStr.toString();
            }else{
                return generateString(len, middleElement%10, carryStr.substring(0, len%2==0?mid+1:mid));
            }
        }

    }

    static String generateString(int strLen, int middleElement, String leftStr){
        StringBuilder reverseStr = new StringBuilder(leftStr);
        reverseStr.reverse();
        if(strLen%2 !=0){
            //add middle element
            reverseStr.insert(0,middleElement);
        }
        reverseStr.insert(0, leftStr);
        return reverseStr.toString();
    }

    public static void main(String[] args) {

        String str = "10";
        String result = smalledPal(str);
        System.out.println(str+" :: "+result);

        str = "11";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);

        str = "12";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);

        str = "29";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);

        str = "111";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);

        str = "121";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);

        str = "122";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);

        str = "221";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "298";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "1224";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "1234";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "1214";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "8999";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "199992";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "12221";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "11111";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "12312";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "12356";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "12426";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "234567";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "222222";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "2345321";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "2345521";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "2349921";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "2399991";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);

        str = "9";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "99";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "999";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "9999";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "99999";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "999999";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "999999999";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "1740948824551711527614232216857618927954312334113874277931986502860248650900613893446066184963788291";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "23921";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);
        str = "23965";
        result = smalledPal(str);
        System.out.println(str+" :: "+result);


//        int[] array = new int[]{ 24, 33, 13, 11, 30, 28, 19, 8, 30, 25, 42, 6, 30, 49, 3, 49, 24, 13, 3, 50 };
//        Arrays.sort(array);
//        int B = 13;
//        int index = findIndex(array, B, 0, array.length-1);
//        int result = -1;
//        if(index >= 0){
//           result = array.length-1-index;
//        }
//        assert result == 13;
//
//
//        array = new int[]{ 16, 36, 26, 14, 31, 43, 43, 10, 34, 19, 20, 30, 11, 14, 30, 34, 47, 22, 48, 47 };
//        Arrays.sort(array);
//        B = 47;
//        index = findIndex(array, B, 0, array.length-1);
//        result = -1;
//        if(index >= 0){
//            result = array.length-1-index;
//        }
//        assert result == 1;
//
//        array = new int[]{ 24, 33, 13, 11, 30, 28, 19, 8, 30, 25, 42, 6, 30, 49, 3, 49, 24, 13, 3, 50, 13 };
//        Arrays.sort(array);
//        B = 13;
//        index = findIndex(array, B, 0, array.length-1);
//        result = -1;
//        if(index >= 0){
//            result = array.length-1-index;
//        }
//        assert result == 13;

    }

    static int findIndex(int[] A, int B, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = start + (end-start)/2;
        if(A[mid] == B){
            //Find all indexes of duplicate items example if B is found then there could be multiple B's on next indexes we need to consider those as well
            do{
                mid++;
            }while(mid < A.length && A[mid] == B);
            return (mid-1);
        }else if(A[mid] > B){
            return findIndex(A, B, start, --mid);
        }else {
            return findIndex(A, B, ++mid, end);
        }
    }
}
