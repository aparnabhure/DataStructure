import java.util.Arrays;
import java.util.List;

public class PartitionLinkList {
    /*
    Given a linked list A and a value B, partition it such that all nodes less than B come before nodes greater than or equal to B.

You should preserve the original relative order of the nodes in each of the two partitions.
     */
    public static void main(String[] args) {
        ListNode.printList(partition(ListNode.generateList(Arrays.asList(192 , 856 , 647 , 251 , 498 , 749 , 252 , 577 ,
            322 , 794 , 490 , 278 , 754 , 505 , 688 , 418 , 486 , 3 , 700 , 680 , 707 , 892 , 37 , 666 , 9 , 858 , 802 ,
            82 , 441 , 500 , 64 , 373 , 174 , 779 , 346 , 803 , 760 , 48 , 783 , 654 , 731 , 391 , 733 , 480 , 5 , 144 ,
            919 , 291 , 180 , 50 , 326 , 90 , 437 , 502 , 527 , 648 , 361 , 828 , 729 , 546 , 934 , 69 , 209 , 187 , 365 ,
            329 , 276 , 86 , 348 , 986 , 344 , 183 , 495 )), 40));
        ListNode.printList(partition(ListNode.generateList(Arrays.asList(18 , 595 , 253 , 7 , 984 , 914 , 903 , 992 , 522 ,
            784 , 55 , 910 , 123 , 133 , 936 , 38 , 774 , 868 , 204 , 727 , 927 , 981 , 766 , 619 , 848 , 398 , 782 , 460 ,
            444 , 805 , 62 , 154 , 35 , 261 , 202 , 622 , 472 , 151 , 590 , 270 , 115 , 773 , 332 , 928 , 298 , 597 , 150 ,
            704 , 229 , 205 , 501 , 284 , 497 , 305 , 864 , 368 , 995 , 731 , 255 , 712 , 614 , 179 , 756 , 432 , 415 , 734 ,
            449 , 85 , 817 , 686 , 829 , 12 , 564 , 427 , 711 , 275 , 109 , 641 , 344 , 934 , 760 , 551 , 958 , 540 , 446)), 34));
        ListNode.printList(partition(ListNode.generateList(Arrays.asList(1, 2,3,4,5)), 5));
        ListNode.printList(partition(ListNode.generateList(Arrays.asList(1, 4, 3, 2, 5, 2)), 3));
        ListNode.printList(partition(ListNode.generateList(Arrays.asList(1, 2, 3, 1, 3)), 2));
    }

    static ListNode partition(ListNode A, int B) {
        if(A == null || A.next == null) return A;

        ListNode temp = A;
        ListNode prev = null;
        ListNode p = null;
        while(temp != null){
            if(temp.val < B){
                if(p == null){
                    prev = temp;
                    temp = temp.next;
                }else {
                    ListNode X = temp;
                    p.next = X.next;
                    if(prev == null){
                        X.next = A;
                        A = X;
                        prev = A;
                    }else {
                        X.next = prev.next;
                        prev.next = X;
                        prev = X;
                    }
                    temp = p.next;
                }
            }else {
                p = temp;
                temp = temp.next;
            }
        }

        return A;
    }
}
