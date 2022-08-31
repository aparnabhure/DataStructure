import java.util.Arrays;

public class ReorderLinkList {
    /*
    Given a singly linked list A

 A: A0 → A1 → … → An-1 → An
reorder it to:

 A0 → An → A1 → An-1 → A2 → An-2 → …
You must do this in-place without altering the nodes' values.
     */
    public static void main(String[] args) {
        ListNode.printList(reorderList(ListNode.generateList(Arrays.asList(
            1,2,3,4,5,6,7,8,9,10 ,
            11,12,13,14,15,26,17,18,19,20))));

        ListNode.printList(reorderList(ListNode.generateList(Arrays.asList(
            12 ,6 ,75 ,98 ,58 ,81 ,30 ,101 ,87 ,40 ,70 ,45 ,41 ,20 ,66 ,1 ,96 ,35 ,51 , 79 ,61 ,48 ,99 ,11 ,32 ,88 ,60 ,
            18 ,42 ,29 ,13 ,91 ,85 ,10 ,33 ,52 ,84 ,4 , 94 ,46 ,23 ,82 ,59 ,38 ,97 ,17 ,14 ,90 ,54 ,69 ,57 ,74 ,73 ,39))));
        ListNode.printList(reorderList(ListNode.generateList(Arrays.asList(99,83))));
        ListNode.printList(reorderList(ListNode.generateList(Arrays.asList(1,2,3,4,5))));
        ListNode.printList(reorderList(ListNode.generateList(Arrays.asList(1,2,3,4))));
    }

    static ListNode reorderList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode middle = findMid(head);
        if(middle == null) return head;
        ListNode h2 = middle;

        h2 = reverse(h2);
        ListNode h1 = head;
        return merge(h1, h2);
    }
    static ListNode reverse(ListNode B){
        ListNode prev = null;
        while(B != null)
        {
            ListNode temp = B.next;
            B.next=prev;
            prev=B;
            B=temp;
        }
        return prev ;
    }

    static ListNode findMid(ListNode A){
        ListNode slow = A ;
        ListNode fast = A ;

        while(fast != null && fast.next != null)
        {
            slow = slow.next ;
            fast = fast.next.next ;
        }
        return slow ;
    }

    static ListNode merge(ListNode A, ListNode B){
        if(A == null) return B;
        if(B == null) return A;

        ListNode head = A;
        while(A != null && B != null){
                ListNode temp = A.next;
                A.next = B;
                A = temp;

                temp = B.next;
                B.next = A;
                B = temp;
        }

        if(A != null){
            A.next = null;
        }

        return head;
    }
}
