import java.util.EmptyStackException;

/**
 * Create Stack with below operations
 * push
 * pop
 * findMiddle
 * insertMiddle
 * deleteMiddle
 *
 * If we use Array operations would be O(n)
 * If we use singly link list then finding and maintening middle would be difficult
 * We will try with Doubly link list
 */
public class StackUsingLinkListWithMiddleOperation {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("***********");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.insertInMiddle(15);
        stack.insertInMiddle(25);
        printStack(stack);
        System.out.println("***********");
        stack.push(1);
        stack.push(2);
        System.out.println(stack.deleteMiddle());
        System.out.println(stack.deleteMiddle());
        System.out.println(stack.deleteMiddle());
        System.out.println("***********");
        stack.insertInMiddle(15);
        System.out.println(stack.findMiddle());
        System.out.println("***********");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.findMiddle());
        System.out.println("***********");
        stack.push(4);
        System.out.println(stack.findMiddle());
    }

    private static void printStack(MyStack stack){
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }


    private static class MyStack{
        private DoublyListNode head;
        private DoublyListNode last;
        private int len = 0;
        public void push(int value){
            DoublyListNode node = new DoublyListNode(value);
            if(head == null){
                head = node;
                last = head;
            }else{
               node.prev = last;
               last.next = node;
               last = node;
            }
            len++;
        }

        public int pop(){
            if(last == null){
                //Pop from stack doesn't throw exception , remove throws
                throw new EmptyStackException();
            }
            int val = last.value;
            last = last.prev;
            if(last == null){
                head = null;
            }
            len--;
            return val;
        }

        public int findMiddle(){
            //Just to get middle element
            if(head == last){
                return head.value;
            }

            DoublyListNode middle = traverseTillMiddle();
            return middle.value;
        }

        public void insertInMiddle(int value){
            if(head == last){
                push(value);
            }else{
                DoublyListNode middle = traverseTillMiddle();
                DoublyListNode newNode = new DoublyListNode(value);
                middle.next.prev = newNode;
                newNode.next = middle.next;
                newNode.prev = middle;
                middle.next = newNode;
            }
            len++;
        }

        public int deleteMiddle(){
            int val = -1;
            if(head == null){
                return val;
            }

            if(head == last){
                val = head.value;
                head = last = null;
            }else{
                DoublyListNode middle = traverseTillMiddle();
                val = middle.value;
                if(middle == head){
                    head = head.next;
                    head.prev = null;
                }else {
                    middle.next.prev = middle.prev;
                    middle.prev.next = middle.next;
                }
            }
            len--;
            return val;
        }

        public boolean empty(){
            return len<=0;
        }

        private DoublyListNode traverseTillMiddle(){
            DoublyListNode tempHead = head;
            DoublyListNode tempLast = last;

            while (tempLast.next != tempHead){
                if(tempHead == tempLast){
                    break;
                }

                tempHead = tempHead.next;
                tempLast = tempLast.prev;
            }

            return tempLast;
        }
    }

    private static class DoublyListNode {
        int value;
        DoublyListNode prev;
        DoublyListNode next;
        DoublyListNode(int value){
            this.value = value;
        }
    }
}
