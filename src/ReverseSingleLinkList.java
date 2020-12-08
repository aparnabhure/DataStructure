import java.util.Stack;

public class ReverseSingleLinkList {
    public static void main(String[] args) {
        ListNode head = fillList(new int[]{1,2,3,4,5,6});
        head = reverseViaStack(head);
        printList(head);
        head = reverseViaPointers(head);
        printList(head);


        head = fillList(new int[]{1, 2, 4, 6, 5, 8, 10, 7, 4, 3});
        head = reverseEvenNodes(head);
        printList(head);

        head = fillList(new int[]{2, 4, 8, 1});//Not worked
        head = reverseEvenNodes(head);
        printList(head);

        head = fillList(new int[]{2, 4,1});
        head = reverseEvenNodes(head);
        printList(head);

        head = fillList(new int[]{2, 4, 6, 5, 8, 10, 7, 4, 3});
        head = reverseEvenNodes(head);
        printList(head);

        head = fillList(new int[]{2, 4});
        head = reverseEvenNodes(head);
        printList(head);

        head = fillList(new int[]{1, 3, 2});
        head = reverseEvenNodes(head);
        printList(head);

        head = fillList(new int[]{1, 2, 3, 4, 6});
        head = reverseEvenNodes(head);
        printList(head);

        head = fillList(new int[]{2, 1, 4, 6, 5, 8, 10, 7, 4, 3});
        head = reverseEvenNodes(head);
        printList(head);


        head = fillList(new int[]{2, 1, 4, 6, 5, 8, 10, 7, 4, 3});
        head = reverseBetween(head, 3, 6);
        printList(head);
    }

    private static void printList(ListNode head){
        System.out.println("************");
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        System.out.println();
        ListNode temp = head;
        System.out.print("[");
        while (temp != null){
            System.out.print(temp.val + ",");
            temp = temp.next;
        }
        System.out.print("]");
        System.out.println();
    }

    private static ListNode fillList(int[] list){
        ListNode head = new ListNode(list[0]);
        ListNode temp = head;
        for(int i=1; i<list.length;i++){
            temp.next = new ListNode(list[i]);
            temp = temp.next;
        }
        return head;
    }

    /**
     * This solution is taking time
     */
    private static ListNode reverseEvenNodes(ListNode head){
        //Having 0 or single node
        if(head == null || head.next == null){
            return head;
        }

        // 1 2 4 6 5 8 10 7 4 3
        //output 1 6 4 2 5 10 8 7 4  3
        //Need to pointer for the node prev to first even node
        //as soon as found the even node need to reverse till node.next.val == even
        ListNode prevEvenNode = null;
        ListNode currentNode = head;
        while (currentNode != null){
            if(currentNode.val%2 == 0 && currentNode.next != null && currentNode.next.val%2 == 0){
                //Reverse till getting even numbers
                ListNode evenHead= currentNode;
                ListNode prev = currentNode;
                ListNode next = prev.next;
                while(next != null && next.val%2 == 0){
                    ListNode temp = next.next;
                    next.next = prev;
                    prev = next;
                    next = temp;
                }
                if(prevEvenNode != null) {
                    prevEvenNode.next = prev;
                }else{
                    prevEvenNode = prev;
                    head = prevEvenNode;
                }
                //This is to point the reversed item in the next
                evenHead.next = next;
                currentNode = next;
            }else{
                prevEvenNode = currentNode;
                currentNode = currentNode.next;
            }
        }

        return head;
    }


    private static ListNode reverseBetween(ListNode head, int from, int to){
        if(head == null || head.next == null || to <=from){
            return head;
        }

        int pos = 1;
        ListNode node = head;
        ListNode prevFrom = null;
        while (node != null && pos<=to){
          if(pos == from){
              ListNode current = node;
              ListNode prev = current;
              ListNode next = prev.next;
              while (next != null && pos<to){
                  ListNode temp = next.next;
                  next.next = prev;
                  prev = next;
                  next = temp;
                  pos++;
              }
              if(prevFrom == null){
                  prevFrom = head = prev;
              }else{
                  prevFrom.next = prev;
              }
              current.next = node = next;
              break;
          }else{
              prevFrom = node;
              node = node.next;
              pos++;
          }


        }

        return head;
    }

    private static ListNode reverseViaPointers(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = head;
        ListNode next = prev.next;
        prev.next = null;

        while (next != null){
            ListNode temp = next.next;
            next.next = prev;
            prev = next;
            next = temp;
        }

        return prev;
    }

    private static ListNode reverseViaStack(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null){
            stack.push(node);
            node = node.next;
        }
        ListNode tHead = stack.pop();
        node = tHead;
        while (!stack.isEmpty()){
            ListNode h = stack.pop();
            node.next = h;
            node = node.next;
        }
        node.next = null;
        return tHead;
    }

    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; }
    }
}
