/**
 *
 * https://leetcode.com
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to
 * display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigZagString {
    public static void main(String[] args){
        System.out.println(convert("aparna", 3));
    }
    private static String convert(String s, int numRows) {
        if(numRows <= 1){
            return s;
        }

        StringBuilder convertedStr = new StringBuilder();

        //For first row factor
        int xRowFactor = (2*numRows - 2);

        for(int row=0; row<numRows; row++){
            for(int j=0; j+row < s.length(); j+= xRowFactor){
                convertedStr.append(s.charAt(row+j));
                //Check for intermitent rows ie not first or last
                if(row != 0 && row != numRows-1 && (j+xRowFactor-row)<s.length()){
                     convertedStr.append(s.charAt(j+xRowFactor-row));
                }
            }
        }

        return convertedStr.toString();
    }


}
