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
        tree.setRoot(Tree.insertLevelOrder(arrray, tree.getRoot(), 0));

        branchSum(tree.getRoot(), 0);
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
