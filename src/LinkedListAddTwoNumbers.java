/**
 * https://leetcode.com
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class LinkedListAddTwoNumbers {

    public static void main(String[] args){

       // int number1 = 842;
       // int number2 = 465;

        int number1 = 84;
        int number2 = 465;

        Solution solution = new Solution();
        ListNode l1 = solution.fillList(number1);
        ListNode l2 = solution.fillList(number2);
        solution.printList(l1);
        solution.printList(l2);

        ListNode summation = solution.addTwoNumbers(l1, l2);
        solution.printList(summation);

    }

    static class Solution {

        public ListNode fillList(int number){
            ListNode node = null;
            ListNode previous = null;

            while (number > 0){
                int mode = number%10;
                number = number/10;
                if(node == null){
                    node = new ListNode(mode);
                    previous = node;
                }else{
                    ListNode newL1 = new ListNode(mode);
                    previous.next = newL1;
                    previous = newL1;
                }
            }
            return node;
        }

        public void printList(ListNode node){
            System.out.println();
            do{
                System.out.print(" "+node.val+" ");
                node = node.next;
            }while (node != null);
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode sumNode = null;
            ListNode previous = null;
            int remainder = 0;
            while (l1 != null || l2 != null) {
                int num1 = 0;
                int num2 = 0;
                if(l1 != null){
                    num1 = l1.val;
                    l1 = l1.next;
                }
                if(l2 != null){
                    num2 = l2.val;
                    l2 = l2.next;
                }

                int sum = num1 + num2 + remainder;
                int sumMode = sum%10;
                remainder = sum/10;

                if(sumNode == null){
                    sumNode = new ListNode(sumMode);
                    previous = sumNode;
                }else{
                    ListNode newL1 = new ListNode(sumMode);
                    previous.next = newL1;
                    previous = newL1;
                }
            }

            if(remainder >0){
                ListNode newL1 = new ListNode(remainder);
                previous.next = newL1;
            }

            return sumNode;
        }
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
