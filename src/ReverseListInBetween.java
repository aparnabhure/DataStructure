import java.util.Arrays;

public class ReverseListInBetween {
    public static void main(String[] args) {
        ListNode head = ListNode.generateList(Arrays.asList(1,2,3));
        ListNode.printList(reverseBetween(head, 1,2));
        ListNode head1 = ListNode.generateList(Arrays.asList(1,2,3));
        ListNode.printList(reverseBetween(head1, 2,3));
    }

    static ListNode reverseBetween(ListNode head, int B, int C) {
        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode current = head;
        int start =1;
        while(current != null && start != B){
            prev = current;
            current = current.next;
            start++;
        }

        if(current == null) return head;
        ListNode firstNode = current;
        ListNode temp = prev;

        while(current != null && start != C+1){

            start++;
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        if(temp != null){
            temp.next = prev;
        }else{
            head = prev;
        }
        firstNode.next = current;

        return head;

    }
}
