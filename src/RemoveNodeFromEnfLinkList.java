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


        ListNode head = ListNode.generatePlainList();

//        ListNode updated = removeNthFromEndTwoPointers(head, 1);
//        ListNode.printList(updated);

        ListNode updated = removeNthFromEndTwoPointers(head, 2);
        ListNode.printList(updated);

        head = ListNode.generatePlainList();
        updated = removeNthFromEndTwoPointers(head, 3);
        ListNode.printList(updated);

        head = ListNode.generatePlainList();
        updated = removeNthFromEndTwoPointers(head, 4);
        ListNode.printList(updated);

        head = ListNode.generatePlainList();
        updated = removeNthFromEndTwoPointers(head, 5);
        ListNode.printList(updated);

        head = ListNode.generatePlainList();
        updated = removeNthFromEndTwoPointers(head, 6);
        ListNode.printList(updated);

        head = ListNode.generatePlainList();
        updated = removeNthFromEndTwoPointers(head, 7);
        ListNode.printList(updated);

      //  System.out.println(removeNthFromEnd(head, 2));

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

    //Approach 2 : Maintain 2 pointers and move other one with Nth steps
    private static ListNode removeNthFromEndTwoPointers(ListNode head, int n){
        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = head;
        ListNode p1 = temp;
        ListNode p2 = temp;


        do{
            for(int i=0; i<n; i++){
                if(p2 == null){
                    break;
                }
                p2 = p2.next;
            }
            if(p2 == null){
                p1.next = p1.next.next;
            }else{
                p1 = p1.next;
            }
        }while (p2 != null);

        return temp;
    }


}
