import java.util.*;

public class BuildTreeFromInOrderPostOrder {
    public static void main(String[] args) {
        TreeNode root = buildTree(Arrays.asList(6, 1, 3, 2), Arrays.asList(6, 3, 2, 1));
        TreeNode.printTreeArray(TreeNode.postorderTraversal(root));
        TreeNode.printTreeArray(TreeNode.inorderTraversal(root));
        TreeNode.printTreeArray(TreeNode.preorderTraversal(root));

        List<Integer> inorder = Arrays.asList(6, 1, 3, 2);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.size(); i++){
            map.put(inorder.get(i), i);
        }
        List<Integer> postorder = Arrays.asList(6, 3, 2, 1);
        root = build(postorder,0, 3, 0, map);
        TreeNode.printTreeArray(TreeNode.postorderTraversal(root));
        TreeNode.printTreeArray(TreeNode.inorderTraversal(root));
        TreeNode.printTreeArray(TreeNode.preorderTraversal(root));
    }

    static TreeNode build(List<Integer> postorder, int pleft, int pright, int ileft, Map<Integer, Integer> map){
        if(pleft>pright){
            return null;
        }

        int val = postorder.get(pright);
        TreeNode node = new TreeNode(val);
        int idx = map.get(val);
        int length = idx-ileft;
        node.left = build(postorder, pleft, pleft+length-1, ileft, map);
        node.right = build(postorder, pleft+length, pright-1, idx+1, map);
        return node;
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