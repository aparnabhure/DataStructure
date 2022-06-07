import java.util.ArrayList;

public class LinkedListOperations {
    /*
    Given a matrix A of size Nx3 representing operations. Your task is to design the linked list based on these operations.

There are four types of operations:

0 x -1: Add a node of value x before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.

1 x -1: Append a node of value x to the last element of the linked list.

2 x index: Add a node of value x before the indexth node in the linked list. If the index equals the length of the linked list, the node will be appended to the end of the linked list. If the index is greater than the length, the node will not be inserted.

3 index -1: Delete the indexth node in the linked list, if the index is valid.

A[i][0] represents the type of operation.

A[i][1], A[i][2] represents the corresponding elements with respect to type of operation.

Note: Indexing is 0 based.
     */

    public static void main(String[] args) {
        ListNode head = solve(testCase2());
        print(head);
        head = solve(testCase1());
        print(head);
    }

    static void print(ListNode head){
        if(head == null){
            System.out.println("Empty list");
            return;
        }

        while(head != null){
            System.out.print(head.val+"->");
            head = head.next;
        }

        System.out.println();
    }

    static ArrayList<ArrayList<Integer>> testCase2(){
        ArrayList<ArrayList<Integer>> operations = new ArrayList<>();
        ArrayList<Integer> steps = new ArrayList<>();
        steps.add(0); steps.add(1); steps.add(-1);
        operations.add(steps);

        steps = new ArrayList<>();
        steps.add(1); steps.add(2); steps.add(-1);
        operations.add(steps);

        steps = new ArrayList<>();
        steps.add(2); steps.add(3); steps.add(1);
        operations.add(steps);

        steps = new ArrayList<>();
        steps.add(0); steps.add(4); steps.add(-1);
        operations.add(steps);

        steps = new ArrayList<>();
        steps.add(3); steps.add(1); steps.add(-1);
        operations.add(steps);

        steps = new ArrayList<>();
        steps.add(3); steps.add(2); steps.add(-1);
        operations.add(steps);

        return operations;
    }

    static ArrayList<ArrayList<Integer>> testCase1(){
        ArrayList<ArrayList<Integer>> operations = new ArrayList<>();
        ArrayList<Integer> steps = new ArrayList<>();
        steps.add(0); steps.add(1); steps.add(-1);
        operations.add(steps);

        steps = new ArrayList<>();
        steps.add(1); steps.add(2); steps.add(-1);
        operations.add(steps);

        steps = new ArrayList<>();
        steps.add(2); steps.add(3); steps.add(1);
        operations.add(steps);

        return operations;
    }

    static ListNode solve(ArrayList<ArrayList<Integer>> A) {
        ListNode head = null;
        for(ArrayList<Integer> operation:A){
            int op = operation.get(0);
            int x = operation.get(1);
            int y = operation.get(2);

            if(op != 3){
                head = insert(op, head, x, y);
            }else{
                head = delete(head, x);
            }

        }

        return head;

    }

    static ListNode delete(ListNode head, int index){
        if(head == null || index < 0){
            return null;
        }

        if(index == 0){
            head = head.next;
            return head;
        }

        if(head.next == null){
            return head;
        }

        int currentIndex = 0;
        ListNode temp = head;
        ListNode prev = null;
        while (currentIndex<index && temp.next != null){
            prev = temp;
            temp = temp.next;
            currentIndex++;
        }

        if(prev != null && currentIndex == index){
            prev.next = temp.next;
        }

        return head;
    }

    static ListNode insert(int operation, ListNode head, int value, int index){
        ListNode node = new ListNode(value);
        if(head == null){
            head = node;
            return head;
        }

        if(operation == 0 || index == 0){
            //Add in front
            node.next = head;
            head = node;
            return head;
        }

        if(operation == 1){
            //Add in last
            ListNode temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
            return head;
        }

        if(operation == 2){
            //Add at index
            ListNode temp = head;
            int currentIndex = 0;
            while(temp.next != null && currentIndex < (index-1)){
                temp = temp.next;
                currentIndex++;
            }
            if(currentIndex == (index-1)){
                //Valid index
                node.next = temp.next;
                temp.next = node;
            }
            return head;
        }

        return head;

    }
}
