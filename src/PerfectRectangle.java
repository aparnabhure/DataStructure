import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/contest/leetcode-weekly-contest-2/problems/perfect-rectangle/
public class PerfectRectangle {
    public static void main(String[] args) {
        System.out.println(isRectangleCover(new int[][]{{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}}));
        System.out.println(isRectangleCover(new int[][]{{1,1,2,3},{1,3,2,4},{3,1,4,2},{3,2,4,4}}));
        System.out.println(isRectangleCover(new int[][]{{1,1,3,3},{3,1,4,2},{1,3,2,4},{2,2,4,4}}));
    }

    static boolean isRectangleCover(int[][] rectangles) {

        int area = 0;
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        Set<String> distinctPoints = new HashSet<>();
        for(int[] points:rectangles){
            int x1 = points[0];
            minX = Math.min(x1, minX);
            int x2 = points[2];
            maxX = Math.max(maxX, x2);
            int y1 = points[1];
            minY = Math.min(minY, y1);
            int y2 = points[3];
            maxY = Math.max(maxY, y2);
            area += area(x1,x2,y1,y2);
            List<String> keys = Arrays.asList(x1+":"+y1, x1+":"+y2, x2+":"+y1, x2+":"+y2);
            keys.forEach(key->{
                if(distinctPoints.contains(key)){
                    distinctPoints.remove(key);
                }else{
                    distinctPoints.add(key);
                }
            });
        }

        int expectedArea = area(minX, maxX, minY, maxY);
        if(expectedArea != area){
            return false;
        }

        if(distinctPoints.size() != 4){
            return false;
        }

        List<String> expectedKeys = Arrays.asList(minX+":"+minY, minX+":"+maxY, maxX+":"+minY, maxX+":"+maxY);
        for(String key:expectedKeys){
            if(!distinctPoints.contains(key)){
                return false;
            }
        }

        return true;


    }

    static int area(int x1, int x2, int y1, int y2){
        return (x2-x1)*(y2-y1);
    }
}
