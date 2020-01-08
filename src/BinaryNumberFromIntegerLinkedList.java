import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 *
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 *
 * Example 1:
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 * Example 2:
 *
 * Input: head = [0]
 * Output: 0
 * Example 3:
 *
 * Input: head = [1]
 * Output: 1
 * Example 4:
 *
 * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * Output: 18880
 * Example 5:
 *
 * Input: head = [0,0]
 * Output: 0
 *
 *
 * Constraints:
 *
 * The Linked List is not empty.
 * Number of nodes will not exceed 30.
 * Each node's value is either 0 or 1.
 */
public class BinaryNumberFromIntegerLinkedList {
    public static void main(String[] args){
        ListNode node = new ListNode(1);
        node.next = new ListNode(0);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(1);
        node.next.next.next.next = new ListNode(0);
        node.next.next.next.next.next = new ListNode(0);
        node.next.next.next.next.next.next = new ListNode(1);
        node.next.next.next.next.next.next.next = new ListNode(1);
        node.next.next.next.next.next.next.next.next = new ListNode(1);
        node.next.next.next.next.next.next.next.next.next = new ListNode(0);
        node.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        node.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        node.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        node.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        node.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);

        System.out.println(getDecimalValue(node));
    }

    private static int getDecimalValue(ListNode head) {

        ListNode temp = head;
        List<Integer> tempNumbers = new ArrayList<>();
        while (temp != null){
            tempNumbers.add(temp.val);
            temp = temp.next;
        }

        int binaryNumber =0;
        int n = tempNumbers.size()-1;
        for(int i=0; i<tempNumbers.size(); i++){
            binaryNumber += (tempNumbers.get(i) * Math.pow(2, n--));
        }

        return binaryNumber;
    }
}

