import java.util.Arrays;

public class LongestPalindromeInLinkList {
    public static void main(String[] args) {
        System.out.println(longestPalindrome(ListNode.generateList(Arrays.asList(2,1,2,1,2,2,13,2,2))));
    }

    static int longestPalindrome(ListNode head){
        int maxLen =1;
        ListNode center = head;
        ListNode prev = null;
        //odd sublist manipulation
        while(center != null){
            int len = 1;
            ListNode right = center.next;
            ListNode t1 = prev;
            ListNode t2 = right;
            while(t1 != null && t2 != null){
                if(t1.val == t2.val) {
                    t1 = t1.next;
                    t2 = t2.next;
                    len+=2;
                    continue;
                }
                break;
            }
            maxLen = Math.max(len,maxLen);
            center.next = prev;
            prev = center;
            center = right;
        }

        //Even Length
        ListNode h = prev;
        prev = null;
        center = h;
        while(center != null && center.next != null){
            ListNode right = center.next;
            if(center.val == right.val){
                int len = 2;
                ListNode next = right.next;
                ListNode t1 = prev;
                ListNode t2 = next;
                while(t1 != null && t2 != null){
                    if(t1.val == t2.val){
                        len+=2;
                        t1 = t1.next;
                        t2 = t2.next;
                        continue;
                    }
                    break;
                }
                maxLen = Math.max(len,maxLen);
            }
            center.next = prev;
            prev = center;
            center = right;
        }
        return maxLen;
    }
}
