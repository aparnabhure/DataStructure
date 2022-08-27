import java.util.Arrays;

public class DeleteMiddleElementFromLinkedList {
    public static void main(String[] args) {
        ListNode.printList(solve(ListNode.generateList(Arrays.asList(1,2))));
        ListNode.printList(solve(ListNode.generateList(Arrays.asList(1,2,3,4,5))));
        ListNode.printList(solve(ListNode.generateList(Arrays.asList(1,2,3,4,5,6))));
    }

    static ListNode solve(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode x = head;
        ListNode y = head;
        ListNode prev = null;
        while(y != null && y.next != null){
            prev = x;
            x = x.next;
            y = y.next.next;
        }

        prev.next = prev.next.next;

        return head;

    }
}
