import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }

    public static List<Integer> inorderTraversal(TreeNode A) {
        List<Integer> ans =new ArrayList<>();
        inorder(A, ans);
        return ans;
    }

    static void inorder(TreeNode root, List<Integer> ans){
        if(root == null) return;
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }

    public static List<Integer> preorderTraversal(TreeNode A) {
        List<Integer> ans =new ArrayList<>();
        preorder(A, ans);
        return ans;
    }

    static void preorder(TreeNode root, List<Integer> ans){
        if(root == null) return;
        ans.add(root.val);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }

    public static List<Integer> postorderTraversal(TreeNode A) {
        List<Integer> ans =new ArrayList<>();
        postorder(A, ans);
        return ans;
    }

    static void postorder(TreeNode root, List<Integer> ans){
        if(root == null) return;
        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.val);
    }

    static void printTreeArray(List<Integer> result){
        for(int i:result){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
