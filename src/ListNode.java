import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode(){}
    ListNode(int x) { val = x; }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public static void printList(ListNode head){
        System.out.println("*************");
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode generatePlainList(){
        ListNode head = new ListNode(1);
        ListNode currentNode = head;

        for(int i=2; i<6; i++){
            ListNode listNode = new ListNode(i);
            currentNode.next = listNode;
            currentNode = listNode;
        }

        return head;
    }

    public static ListNode generateList(List<Integer> list){
        ListNode head = null;
        ListNode temp = null;
        for (int i:list){
            ListNode node = new ListNode(i);
            if(head == null){
                head = node;
                temp = head;
            }else {
                temp.next = node;
                temp = temp.next;
            }
        }
        return head;
    }
}
