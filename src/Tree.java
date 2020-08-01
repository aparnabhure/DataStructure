public class Tree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    static class Node
    {
        private int value = 0;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public static Tree.Node insertLevelOrder(int[] arr, Tree.Node root,
                                              int i)
    {
        // Base case for recursion
        if (i < arr.length) {
            Tree.Node temp = new Tree.Node(arr[i]);
            root = temp;

            // insert left child
            root.setLeft(insertLevelOrder(arr, root.getLeft(),
                    2 * i + 1));

            // insert right child
            root.setRight(insertLevelOrder(arr, root.getRight(),
                    2 * i + 2));
        }
        return root;
    }

}
