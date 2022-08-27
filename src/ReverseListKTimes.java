import java.util.Arrays;

public class ReverseListKTimes {

    public static void main(String[] args) {
        ListNode head = ListNode.generateList(Arrays.asList(1, 2, 3, 4, 5, 6));
        ListNode.printList(reverse(head, 2));

        ListNode head1 = ListNode.generateList(Arrays.asList(1, 2, 3, 4, 5, 6));
        ListNode.printList(reverse(head1, 3));
    }
    static ListNode reverse(ListNode head, int B){
        if(head == null || head.next == null) return head;
        ListNode previous = null;
        ListNode first = head;
        while(first != null){
            ListNode prev = null;
            ListNode current = first;
            int X = B;
            while(current != null && X >0){
                X--;
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            if(previous != null)
                previous.next = prev;
            else
                head = prev;

            first.next = current;
            previous = first;
            first = current;
        }

        return head;
    }
}
