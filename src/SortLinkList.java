import java.util.Arrays;

public class SortLinkList {
    public static void main(String[] args) {
        ListNode.printList(sortList(ListNode.generateList(Arrays.asList(3,2,6,4))));
        ListNode.printList(sortList(ListNode.generateList(Arrays.asList(3,2,6,4, 1, 10,5,3,7))));
    }

    static ListNode sortList(ListNode head){
        return mergeSort(head);
    }

    static ListNode mergeSort(ListNode node){
        if(node == null || node.next == null){
            return node;
        }

        ListNode mid1 = findMid(node);
        ListNode mid2 = mid1.next;
        mid1.next = null;

        ListNode h1 = mergeSort(node);
        ListNode h2 = mergeSort(mid2);

        return merge(h1,h2);
    }

    static ListNode merge(ListNode A, ListNode B){
        if(A == null) return B;
        if(B == null) return A;

        ListNode head = new ListNode(-1);
        ListNode temp = head;

        while(A != null && B != null){
            if(A.val<=B.val){
                temp.next = A;
                A = A.next;
            }else{
                temp.next = B;
                B = B.next;
            }
            temp = temp.next;
        }

        while(A != null){
            temp.next = A;
            A = A.next;
            temp = temp.next;
        }

        while(B != null){
            temp.next = B;
            B = B.next;
            temp = temp.next;
        }
        if(temp != null) temp.next = null;

        head = head.next;
        return head;
    }

    static ListNode findMid(ListNode node){
        ListNode slow = node;
        ListNode fast = node;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
