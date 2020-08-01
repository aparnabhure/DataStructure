public class NodeDepthSum {
    public static void main(String[] args) {
        /*
        Example
                tree
                 1--------------0
               2   3 -----------1
             4  5  6 7----------2
           8  9-----------------3

           Sum would be
           0(1) + 1(2)+1(3) + 2(4) + 2(5)+2(6)+2(7) + 3(8)+3(9) = 16
         */
        int[] arrray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Tree tree = new Tree();
        //Fill the BST tree
        tree.setRoot(Tree.insertLevelOrder(arrray, tree.getRoot(), 0));

        System.out.println("Sum "+ depthSum(tree.getRoot(), 0));
    }

    private static int depthSum(Tree.Node node,int depth){
        if(node == null){
            return 0;
        }
        int sum  = depth + depthSum(node.getLeft(), depth+1) + depthSum(node.getRight(), depth+1);
        System.out.println("*** "+ sum);
        return sum;
    }
}
