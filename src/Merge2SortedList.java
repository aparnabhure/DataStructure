import java.util.Arrays;

public class Merge2SortedList {
    public static void main(String[] args) {
        ListNode l1 = ListNode.generateList(Arrays.asList(1, 2, 4));
        ListNode l2 = ListNode.generateList(Arrays.asList(1, 3, 4));
        ListNode result = mergeTwoLists(l1, l2);
        ListNode.printList(result);

        l1 = ListNode.generateList(Arrays.asList(2));
        l2 = ListNode.generateList(Arrays.asList(1));
        result = mergeTwoLists(l1, l2);
        ListNode.printList(result);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode head = null;
        ListNode temp = null;

        while(true){
            if(l1 == null || l2 == null){
                break;
            }

            if(l1.val <= l2.val){
                if(head == null){
                    head = l1;
                    temp = head;
                }else{
                    temp.next = l1;
                    temp = temp.next;
                }

                l1 = l1.next;
            }else{
                if(head == null){
                    head = l2;
                    temp = head;
                }else{
                    temp.next = l2;
                    temp = temp.next;
                }

                l2 = l2.next;
            }
        }

        if(l1 != null){
            temp.next = l1;
        }else if(l2 != null){
            temp.next = l2;
        }


        return head;

    }
}
