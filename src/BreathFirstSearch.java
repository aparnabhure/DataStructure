import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class BreathFirstSearch {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,7,10,13,14,15,22};
        Tree tree =new Tree();

        //Create Binary tree
        Tree.Node root = constructBT(tree.getRoot(), nums, 0, nums.length-1);
        tree.setRoot(root);

        //Perform BFS on given binary tree
        bfs(root);

    }

    private static void bfs(Tree.Node root){
        Queue<Tree.Node> queue = new LinkedBlockingDeque<>();
        queue.add(root);


        while (!queue.isEmpty()){
            Tree.Node node = queue.poll();
            System.out.println(" "+node.getValue());
            if(node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if(node.getRight() != null) {
                queue.add(node.getRight());
            }
        }

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
