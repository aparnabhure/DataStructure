/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 */
public class RemoveNodeFromEnfLinkList {

    public static void main(String[] args){


        ListNode head = new ListNode(1);
        ListNode currentNode = head;

        for(int i=2; i<6; i++){
            ListNode listNode = new ListNode(i);
            currentNode.next = listNode;
            currentNode = listNode;
        }

        System.out.println(removeNthFromEnd(head, 2));

    }

    //Approach 1: Find length and then remove: It will take two iterations
    private static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode tempHead = head;
        int length=0;

        while (tempHead != null){
            length++;
            tempHead = tempHead.next;
        }

        if(length == n){
            return head.next;
        }

        int nodeToDelete = length-n;
        tempHead = head;

        while (nodeToDelete >= 0){
            tempHead = tempHead.next;
            nodeToDelete--;
        }

        tempHead.next = tempHead.next.next;


        return head;
    }


}

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; }
}
