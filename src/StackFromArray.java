import java.util.EmptyStackException;

public class StackFromArray {
    public static void main(String[] args){
        Stack stack = new Stack(5);
        stack.push(3);
        stack.push(6);
        stack.push(1);
        stack.push(2);
        stack.push(9);
        try{
            stack.push(7);
        }catch (StackOverflowError e){
            System.out.println(e.getMessage());
        }

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        try{
            System.out.println(stack.pop());
        }catch (EmptyStackException e){
            System.out.println(e.getMessage());
        }
    }

    static class Stack{
        int[] array;
        int size;
        int index = 0;

        public Stack(int size){
            this.size = size;
            array = new int[size];
        }

        public boolean isFull(){
            if(index == size){
                return true;
            }

            return false;
        }

        public boolean isEmpty(){
            if(index == 0){
                return true;
            }

            return false;
        }

        public void push(int element){
            if(isFull()){
                throw new StackOverflowError();
            }

            array[index] = element;
            index++;
        }

        public int pop(){
            if(isEmpty()){
                throw new EmptyStackException();
            }

            int element = array[index-1];
            index--;
            return element;
        }
    }

}
