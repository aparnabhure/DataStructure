import java.util.Arrays;

public class LinkListPalindrome {
    public static void main(String[] args) {
        System.out.println(lPalin(ListNode.generateList(Arrays.asList(10,2, 10))));
    }

    static int lPalin(ListNode head) {
        if(head == null || head.next == null) return 1;

        ListNode middle = findMid(head);
        ListNode h2 = middle;

        h2 = reverse(h2);
        ListNode h1 = head;
        return compare(h1, h2);
    }

    static int compare(ListNode A, ListNode B){
        if(A == null) return 0;
        if(B == null) return 0;

        while(A != null && B != null){
            if(A.val != B.val) return 0;
            A = A.next;
            B = B.next;
        }

        return 1;
    }

    static ListNode reverse(ListNode B){
        ListNode prev = null;
        while(B != null)
        {
            ListNode temp = B.next;
            B.next=prev;
            prev=B;
            B=temp;
        }
        return prev ;
    }

    static ListNode findMid(ListNode A){
        ListNode slow = A ;
        ListNode fast = A ;

        while(fast != null && fast.next != null)
        {
            slow = slow.next ;
            fast = fast.next.next ;
        }
        return slow ;
    }
}
