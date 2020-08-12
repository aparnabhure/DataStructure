public class BinarySearchTreeWithMinHeight {
    public static void main(String[] args) {
        //Constraint array should be sorted and have distinct values then only it would work properly
        int[] nums = new int[]{1,2,5,7,10,13,14,15,22};
        Tree tree =new Tree();
        Tree.Node root = constructBT(tree.getRoot(), nums, 0, nums.length-1);
        tree.setRoot(root);
        System.out.println(tree.getRoot().getValue());

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
