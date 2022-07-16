import java.util.Stack;

//https://leetcode.com/contest/warm-up-contest/problems/longest-absolute-file-path/
public class LongestAbsolutePath {
    public static void main(String[] args) {
        System.out.println(solve("a\n\taa\n\t\taaa\n\t\t\tfile1.txt\naaaaaaaaaaaaaaaaaaaaa\n\tsth.png"));
        System.out.println(solve("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
        System.out.println(solve("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }

    static int solve(String path){
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        String[] subPaths = path.split("\n");
        for(String subPath:subPaths){
            int len = subPath.length(); // includes tab as well
            int level = subPath.lastIndexOf("\t") + 1; // for eg: dir level is 0

            // stack.size() is similar to recursion or imagine it as a tree which will record the
            //  number nodes in that path, but if we encounter a string which has level less than stack size then it means we need to backtrack i.e pop the stack contents till we reach to the level where our current string is at. (Similar to cd.. operation in Linux, to go to the parent directory)
            while(stack.size() > level + 1) {
                stack.pop();
            }
            int actualWordLen = len - level;

            // to check if word is a file, and then calculate the max
            if(subPath.contains(".")) {
                max = Math.max(max, stack.peek() + actualWordLen); // since it will be last word in the string we don't have to add forward slash.
            }
            else {
                stack.push(stack.peek() + actualWordLen + 1); // 1 for forward slash
            }
        }

        return max;
    }
}
