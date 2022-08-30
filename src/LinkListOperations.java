public class LinkListOperations {
    public static void main(String[] args) {
        for(int i=1; i<=60; i++){
            insert_node(i, i);
        }
        delete_node(25);
        print_ll();
        delete_node(53);
        print_ll();
        delete_node(12);
        delete_node(54);
        print_ll();
        print_ll();
        print_ll();
        delete_node(39);
        delete_node(42);
        print_ll();
        delete_node(47);
        delete_node(45);
        delete_node(35);
        print_ll();
        delete_node(13);
        print_ll();
        delete_node(18);
        delete_node(59);
        delete_node(47);
        delete_node(43);
        delete_node(38);
        print_ll();
        print_ll();
        print_ll();
        print_ll();
        print_ll();
        print_ll();
        delete_node(8);
        print_ll();
        delete_node(8);
        print_ll();
        delete_node(39);
        delete_node(60);
        delete_node(16);
        print_ll();
        print_ll();
    }

    static ListNode head;

    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        if(head != null){
            if(position == 1){
                ListNode node = new ListNode();
                node.val = value;
                node.next = head;
                head = node;
                return;
            }
            int x = 1;
            ListNode prev = null;
            ListNode temp = head;

            while(temp != null && x != position){
                x++;
                prev = temp;
                temp = temp.next;
            }
            ListNode node = new ListNode();
            node.val = value;
            node.next = temp;
            prev.next = node;
        }else{
            head = new ListNode();
            head.val = value;
        }
    }

    public static void delete_node(int position) {
        // @params position, integer
        if(head != null){
            if(position == 1){
                head = head.next;
                return;
            }

            int x = 1;
            ListNode prev = head;
            ListNode temp = head.next;
            while(temp != null){
                x++;
                if(x == position){
                    prev.next = temp.next;
                    break;
                }
                prev = temp;
                temp = temp.next;
            }
        }
    }

    public static void print_ll() {
        // Output each element followed by a space
        ListNode temp = head;
        while(temp.next != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.print(temp.val);
    }
}
