import java.util.Arrays;

public class RemoveKPositionNodeFromEnd {
    public static void main(String[] args) {
        ListNode.printList(removeNthFromEnd(ListNode.generateList(Arrays.asList(1,2,3,4,5)), 1));
    }

    static ListNode removeNthFromEnd(ListNode head, int B) {
        if(head == null || head.next == null) return null;

        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }

        int nodeToDelete = size-B+1;
        if(B > size || nodeToDelete == 1){
            head = head.next;
            return head;
        }


        ListNode prev = head;
        temp = head.next;
        int pos = 2;

        do{
            if(pos == nodeToDelete){
                prev.next = temp.next;
                break;
            }
            pos++;
            prev = temp;
            temp = temp.next;
        }while(temp != null);

        return head;
    }
}
