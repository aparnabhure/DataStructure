import java.util.*;

public class DeserializeTree {
    //Level order array given
    public static void main(String[] args) {
        TreeNode root =deserialize(Arrays.asList(1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1));
        System.out.println(root.val);
        print(serialize(root));
        root =deserialize(Arrays.asList(1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1));
        System.out.println(root.val);
        print(serialize(root));
    }

    static void print(ArrayList<Integer> result){
        for(int i:result){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static TreeNode deserialize(List<Integer> A){
        TreeNode root = new TreeNode(A.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        int n = A.size();
        while (!queue.isEmpty() && i<n-1){
            TreeNode  node = queue.poll();
            if(node != null){
                int l = A.get(i);
                int r = A.get(++i);
                i++;
                node.left = (l==-1)?null:new TreeNode(l);
                node.right = (r==-1)?null:new TreeNode(r);
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return root;
    }

    static ArrayList<Integer> serialize(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(A != null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(A);
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                ans.add(node==null?-1:node.val);
                if(node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        return ans;
    }
}
