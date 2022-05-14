import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/maximum-white-tiles-covered-by-a-carpet
public class MaximunWhiteTitles {
    public static void main(String[] args) {
        int[][] titles = new int[][]{{8051,8057},{8074,8089},{7994,7995},{7969,7987},{8013,8020},{8123,8139},{7930,7950},
            {8096,8104},{7917,7925},{8027,8035},{8003,8011}};
        int carpetLen = 9854;
        System.out.println(maximumWhiteTiles(titles, carpetLen));

    }

    static int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int len = tiles.length;

        Arrays.sort(tiles, Comparator.comparingInt(i -> i[0]));

        int rv = 0, overlap = 0, ei = 0, prevEnd = 0;
        for (int si = 0; si <len; si++) {
            int st = tiles[si][0], end = st + carpetLen - 1;
            if (si > 0) {
                overlap -= (Math.min(prevEnd, tiles[si-1][1]) - tiles[si-1][0] + 1);
            }
            if (ei > 0 && tiles[ei-1][1] > prevEnd) {
                overlap += (Math.min(end, tiles[ei-1][1]) - prevEnd);
            }

            while (ei < tiles.length && tiles[ei][0] <= end) {
                overlap += (Math.min(end, tiles[ei][1]) - tiles[ei][0] + 1);
                ei++;
            }

            prevEnd = end;
            rv = Math.max(overlap, rv);
        }
        return rv;

    }
}
