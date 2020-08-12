import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Inverting is like mirror view
 *          1
 *        2   3
 *      4    6  7
  invert view would be
            1
         3      2
        7  6      4

 */

public class InvertBinaryTree {
    public static void main(String[] args) {
        //Constraint array should be sorted and have distinct values then only it would work properly
        int[] nums = new int[]{1,2,5,7,10,13,14,15,22};
        Tree tree =new Tree();
        Tree.Node root = constructBT(tree.getRoot(), nums, 0, nums.length-1);
        tree.setRoot(root);

        Tree.Node newRoot = invertBTBFS(root);
        System.out.println(newRoot.getValue());

        invertBTBFSRecursive(root);
        System.out.println(root.getValue());

    }
    //O(N) | space O(n) n = nodes
    private static Tree.Node invertBTBFS(Tree.Node root){
        Queue<Tree.Node> queue = new LinkedBlockingDeque<>();
        queue.add(root);


        while (!queue.isEmpty()){
            Tree.Node node = queue.poll();

            //Swap the left and right nodes
            Tree.Node temp = node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(temp);

            if(node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if(node.getRight() != null) {
                queue.add(node.getRight());
            }
        }

        return root;
    }



    //O(N) | space O(d) d = depth
    private static void invertBTBFSRecursive(Tree.Node root){
        if(root == null){
            return;
        }

        //Swap the left and right nodes
        Tree.Node temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);

        invertBTBFSRecursive(root.getLeft());
        invertBTBFSRecursive(root.getRight());
    }

    private static Tree.Node constructBT(Tree.Node root, int[] nums, int start, int end){
        if(end <start){
            return root;
        }
        int mid = (start+end)/2;
        if(root == null){
            root = new Tree.Node(nums[mid]);
        }else {
            insertNode(root, nums[mid]);
        }

        constructBT(root, nums,start, mid-1);
        constructBT(root, nums, mid+1, end);
        return root;

    }

    private static void insertNode(Tree.Node root, int value){
        if(value < root.getValue()){
            if(root.getLeft() == null){
                root.setLeft(new Tree.Node(value));
            }else{
                insertNode(root.getLeft(),value);
            }
        }else{
            if(root.getRight() == null){
                root.setRight(new Tree.Node(value));
            }else{
                insertNode(root.getRight(),value);
            }
        }
    }
}
