//https://leetcode.com/contest/biweekly-contest-83/problems/shortest-impossible-sequence-of-rolls/
public class SmallestSequenceNotCountable {
    public static void main(String[] args) {
        System.out.println(shortestSequence(new int[]{4,2,1,2,3,3,2,4,1}, 4));
        System.out.println(shortestSequence(new int[]{1,1,2,2}, 2));
    }

    static int shortestSequence(int[] rolls, int k) {
        int seq = 0, cnt = 0;
        int[] dice = new int[100001];
        for (int r : rolls) {
            if (dice[r] == seq) {
                dice[r] = seq + 1;
                if (++cnt % k == 0)
                    ++seq;
            }
        }
        return seq + 1;
    }
}
