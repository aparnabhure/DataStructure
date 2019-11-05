import java.util.*;

/**
 * https://leetcode.com/problems/integer-to-roman/
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: 3
Output: "III"

Example 2:

Input: 4
Output: "IV"

Example 3:

Input: 9
Output: "IX"

Example 4:

Input: 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.

Example 5:

Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


 * @author aparnabhure
 *
 */


public class IntegerToRomanConversion {
	
	private static int I = 1;
	private static int IV = 4;
	private static int V = 5;
	private static int IX = 9;
	private static int X = 10;
	private static int L = 50;
	private static int XL = 40;
	private static int XC = 90;
	private static int C= 100;
	private static int CD = 400;
	private static int D = 500;
	private static int CM = 900;
	private static int M = 1000;
	

	public static void main(String[] args) {
	

		//System.out.println(intToRoman(122));
	//	System.out.println(intToRoman(20));
//		System.out.println(intToRoman(1994));
//		System.out.println(intToRoman(3999));
//		System.out.println(intToRoman(2));
//		System.out.println(intToRoman(444));
		System.out.println(intToRoman(232));



	}
	
	private static String intToRoman(int num) {
		StringBuilder result = new StringBuilder();
		while(num > 0){
			if(num >= M){
				num = num - M;
				result.append("M");
			}else if( num>=CM){
				num = num - CM;
				result.append("CM");
			}else if(num>=D){
				num = num - D;
				result.append("D");
			}else if(num>=CD){
				num = num - CD;
				result.append("CD");
			}else if(num>=C){
				num = num - C;
				result.append("C");
			}else if(num>=XC){
				num = num - XC;
				result.append("XC");
			}else if(num>=L){
				num = num - L;
				result.append("L");
			}else if(num>=XL){
				num = num - XL;
				result.append("XL");
			}else if(num>=X){
				num = num - X;
				result.append("X");
			}else if(num>=IX){
				num = num - IX;
				result.append("IX");
			}else if(num>=V){
				num = num - V;
				result.append("V");
			}else if(num>=IV){
				num = num - IV;
				result.append("IV");
			}else if(num>=I){
				num = num - I;
				result.append("I");
			}
		}
		
		
     return result.toString();   
    }

}
