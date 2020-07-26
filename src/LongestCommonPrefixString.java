/**
 * https://leetcode.com/problems/longest-common-prefix/
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Note:

All given inputs are in lowercase letters a-z.

 * @author aparnabhure
 *
 */
public class LongestCommonPrefixString {

	public static void main(String[] args) {
	    System.out.println(findCommonPrefixStringLength(new char[]{'a','p','a','r','n','a'}, new char[]{'a','p','r','n','a'}, 6, 5, 0));

        System.out.println(findCommonPrefixStringLength(new char[]{'n','a','m','e'}, new char[]{'e','m','a','i','l'}, 4, 5, 0));



        String[] strs =new String[]{"flower","flow","flight"};
		System.out.println(longestCommonPrefix(strs));
		strs =new String[]{"dog","racecar","car"};
		System.out.println(longestCommonPrefix(strs));
		strs =new String[]{"apa","apar"};
		System.out.println(longestCommonPrefix(strs));
		strs =new String[]{"apar","aparna","xyz"};
		System.out.println(longestCommonPrefix(strs));
		strs =new String[]{"apar","aparna","a"};
		System.out.println(longestCommonPrefix(strs));
		strs =new String[]{};
		System.out.println(longestCommonPrefix(strs));
		strs =new String[]{"apar"};
		System.out.println(longestCommonPrefix(strs));

	}
	
	private static String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length <= 0){
			return "";
		}
		
		String newString =  strs[0];
		for(int i=1; i<strs.length; i++){
			String secondString = strs[i];
			newString = findCommonPrefix(newString, secondString); 
			
			
		}
        return newString.toString();
    }
	
	private static String findCommonPrefix(String str1, String str2){
		int str1Len = str1.length();
		int str2Len = str2.length();
		int len = Math.min(str1Len, str2Len);
		StringBuilder str = new StringBuilder();
		for(int i=0; i<len; i++){
			if(str1.charAt(i) != str2.charAt(i)){
				break;
			}
			str.append(str1.charAt(i));
		}
		return str.toString();
	}

	private static int findCommonPrefixStringLength(char[] x, char[] y, int m, int n, int count){
	    if(m <= 0 || n <= 0){
	        return count;
        }

	    int count1 = count;
	    if(x[m-1] == y[n-1]){
	        count1 = findCommonPrefixStringLength(x, y, m-1, n-1, count+1);
        }
	    int count2 = findCommonPrefixStringLength(x, y, m-1, n, 0);
	    int count3 = findCommonPrefixStringLength(x, y, m, n-1, 0);

	    return Math.max(count1, Math.max(count2, count3));

    }

}
