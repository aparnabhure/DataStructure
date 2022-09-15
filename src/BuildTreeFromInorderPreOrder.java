import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BuildTreeFromInorderPreOrder {
    public static void main(String[] args) {
//        TreeNode root = buildTree(Arrays.asList(2, 1, 3), Arrays.asList(1, 2, 3));
//        TreeNode.printTreeArray(TreeNode.postorderTraversal(root));
//        TreeNode.printTreeArray(TreeNode.inorderTraversal(root));
//        TreeNode.printTreeArray(TreeNode.preorderTraversal(root));
        TreeNode root1 = buildTree(Arrays.asList(6, 1, 3, 2), Arrays.asList(1, 6, 2, 3));
        TreeNode.printTreeArray(TreeNode.postorderTraversal(root1));
        TreeNode.printTreeArray(TreeNode.inorderTraversal(root1));
        TreeNode.printTreeArray(TreeNode.preorderTraversal(root1));
    }

    static int index=0;
    static TreeNode buildTree(List<Integer> inorder, List<Integer> preorder) {
        if (inorder == null || preorder == null || (inorder.size() != preorder.size())) return null;
        int n = preorder.size();
        return build(inorder, preorder, index, n-1);
    }

    static TreeNode build(List<Integer> inorder, List<Integer> preorder, int left, int right) {
        if (index >= inorder.size() || left > right) {
            return null;
        }

        TreeNode root = new TreeNode(preorder.get(index));

        for (int i = left; i <= right; i++) {
            if (Objects.equals(preorder.get(index), inorder.get(i))) {
                index++;
                root.left = build(inorder, preorder, left, i-1);
                root.right = build(inorder, preorder, i+1, right);
                break;
            }
        }
        return root;
    }
}
