import java.util.Arrays;

public class RemoveLoopFromLinkList {
    public static void main(String[] args) {
        ListNode.printList(solve(ListNode.generateList(Arrays.asList(254, 398, 52, 125,
            390, 412, 135, 203, 245, 341, 153, 119, 343, 212, 280, 79, 441, 323, 159, 408 ))));

        ListNode.printList(solve(ListNode.generateLoopingList(Arrays.asList(1,2 ))));
        ListNode cycledNode = detectCycle(ListNode.generateLoopingList(Arrays.asList(1,2 )));
        System.out.println(cycledNode==null? "No cycle detected": cycledNode.val);
    }

    static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode cycled = hasCycle(head);
        if(cycled == null){
            return null;
        }

        ListNode left = head;
        ListNode right = cycled;
        while (left != right){
            left = left.next;
            right = right.next;
        }

        return left;
    }

    static ListNode solve(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode cycled = hasCycle(head);
        if(cycled == null){
            return head;
        }

        ListNode prev = null;
        ListNode left = head;
        ListNode right = cycled;
        while (left != right){
            left = left.next;
            prev = right;
            right = right.next;
        }
        if(prev == null) left.next.next = null;
        else prev.next = null;
        return head;
    }

    static ListNode hasCycle(ListNode head){
        if(head == null || head.next == null) return null;
        ListNode prev = head;
        ListNode curr = head;
        while (curr != null && curr.next != null){
            prev = prev.next;
            curr = curr.next.next;
            if(prev == curr){
                return prev;
            }
        }
        return null;
    }
}
