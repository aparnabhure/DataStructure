/**
 * Sum of eachbranch in tree
 *
 *
 */

public class BranchSum {
    public static void main(String[] args) {

        int[] arrray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Tree tree = new Tree();
        //Fill the BST tree
        tree.setRoot(insertLevelOrder(arrray, tree.getRoot(), 0));

        branchSum(tree.getRoot(), 0);
    }

    private static Tree.Node insertLevelOrder(int[] arr, Tree.Node root,
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

    /**
     * DFS
     * @param node
     * @param sum
     */
    private static void branchSum(Tree.Node node, int sum){
        if(node.getLeft() ==null && node.getRight()==null){
            sum += node.getValue();
            System.out.println(sum);
            return;
        }
        sum += node.getValue();
        if(node.getLeft() != null) {
            branchSum(node.getLeft(), sum);
        }
        if(node.getRight() !=null) {
            branchSum(node.getRight(), sum);
        }
    }

}
