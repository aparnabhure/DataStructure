import java.util.*;
import java.util.stream.Collectors;

/**
 * Calculate average for each level of the tree
 *
 * input
 *             4
 *            /\
 *       7          9
 *      /\         /  \
 *     2  3      10   13
 *    /    \     /     \
 *   1      5   5       16
 *         /     \       \
 *       3        6       14
 *               /
 *              3
 *               \
 *                7
 *
 * output:
 * [(4)/1, (7+9)/2, (2+3+10+13)/4, (1+5+5+16)/4, (3+6+14)/3, (3)/1, (7)/1]
 * [4, 16/2,28/4,27/4,23/3,3/1,7/1]
 * [4,8,7,6,7,3,7]
 */
public class BinarySearchTreeCalculateEachLevelAverage {
    public static void main(String[] args) {
        Tree.Node root = fillBtWithSample();
        List<Integer> levelAverageList = computeAvg(root);
        System.out.println(levelAverageList.toString());

        levelAverageList = computeAverageBFS(root);
        System.out.println(levelAverageList.toString());
    }

    private static List<Integer> computeAvg(Tree.Node root){
        Map<Integer, int[]> levels = new HashMap<>();
        computeLevelsDFS(root, levels, 0);
        return calculateAvg(levels);
    }

    //DFS
    private static void computeLevelsDFS(Tree.Node node, Map<Integer, int[]> levels, int level){
        if(node == null){
            return;
        }
        int val = node.getValue();
        int nodesOnLevel = 1;
        if(levels.containsKey(level)){
            int[] value = levels.get(level);
            val+=value[0];
            nodesOnLevel += value[1];
        }
        levels.put(level, new int[]{val, nodesOnLevel});

        computeLevelsDFS(node.getLeft(), levels, level+1);
        computeLevelsDFS(node.getRight(), levels, level+1);
    }


    private static List<Integer> calculateAvg(Map<Integer, int[]> levels){
        List<Integer> avgList = new ArrayList<>();
        int[] result = levels.values().stream().mapToInt(item->(item[0]/item[1])).toArray();

        List<int[]> values = levels.values().stream().collect(Collectors.toList());
        for(int[] item:values){
            avgList.add(item[0]/item[1]);
        }
        return avgList;
    }

    //BFS
    private static List<Integer> computeAverageBFS(Tree.Node root){
        Queue<Tree.Node> levelQueue = new LinkedList<>();
        List<Integer> avgList = new ArrayList<>();
        if(root == null){
            return avgList;
        }

        if(root.getLeft() != null) {
            levelQueue.add(root.getLeft());
        }
        if(null != root.getRight()) {
            levelQueue.add(root.getRight());
        }
        //Add first level value as it always be 1 node
        avgList.add(root.getValue());


        while (!levelQueue.isEmpty()){
            //Traverse through temp level table
            int count=0;
            int sum =0;
            Queue<Tree.Node> tempQueue = new LinkedList<>();
            while (!levelQueue.isEmpty()){
                Tree.Node node = levelQueue.poll();
                if(node.getRight() != null) {
                    tempQueue.add(node.getRight());
                }
                if(node.getLeft() != null) {
                    tempQueue.add(node.getLeft());
                }
                sum+=node.getValue();
                count++;
            }
            if(count > 0) {
                avgList.add(sum / count);
            }

            //Refill temp level queue
            levelQueue = tempQueue;
        }

        return avgList;
    }


    private static Tree.Node fillBtWithSample(){
        Tree.Node root = new Tree.Node(4);
        root.setLeft(new Tree.Node(7));
        root.setRight(new Tree.Node(9));
        root.getLeft().setLeft(new Tree.Node(2));
        root.getLeft().setRight(new Tree.Node(3));
        root.getLeft().getLeft().setLeft(new Tree.Node(1));
        root.getLeft().getRight().setRight(new Tree.Node(5));
        root.getLeft().getRight().getRight().setLeft(new Tree.Node(3));

        root.getRight().setLeft(new Tree.Node(10));
        root.getRight().setRight(new Tree.Node(13));
        root.getRight().getLeft().setLeft(new Tree.Node(5));
        root.getRight().getLeft().getLeft().setRight(new Tree.Node(6));
        root.getRight().getLeft().getLeft().getRight().setLeft(new Tree.Node(3));
        root.getRight().getLeft().getLeft().getRight().getLeft().setRight(new Tree.Node(7));

        root.getRight().getRight().setRight(new Tree.Node(16));
        root.getRight().getRight().getRight().setRight(new Tree.Node(14));
        return root;
    }
}
