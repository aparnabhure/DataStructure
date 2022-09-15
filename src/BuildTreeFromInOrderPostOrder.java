import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BuildTreeFromInOrderPostOrder {
    public static void main(String[] args) {
        TreeNode root = buildTree(Arrays.asList(6, 1, 3, 2), Arrays.asList(6, 3, 2, 1));
        TreeNode.printTreeArray(TreeNode.inorderTraversal(root));
    }

    static int index=0;
    static TreeNode buildTree(List<Integer> inorder, List<Integer> postorder) {
        if (inorder == null || postorder == null || (inorder.size() != postorder.size())) return null;
        int n = postorder.size();
        index = n-1;
        return build(inorder, postorder, 0, index);
    }

    static TreeNode build(List<Integer> inorder, List<Integer> postorder, int left, int right) {
        if (index < 0 || left > right) {
            return null;
        }

        TreeNode root = new TreeNode(postorder.get(index));

        for (int i = left; i <= right; i++) {
            if (Objects.equals(postorder.get(index), inorder.get(i))) {
                index--;
                root.right = build(inorder, postorder, i + 1, right);
                root.left = build(inorder, postorder, left, i - 1);
                break;
            }
        }
        return root;
    }
}