import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/contest/weekly-contest-294/problems/minimum-lines-to-represent-a-line-chart/
public class MinimumLines {
    public static void main(String[] args) {
        int[][] stockPrices = new int[][]{{1,7},{2,6},{3,5},{4,4},{5,4},{6,3},{7,2},{8,1}};
        System.out.println(minimumLines(stockPrices));
        stockPrices = new int[][]{{3,4},{1,2},{7,8},{2,3}};
        System.out.println(minimumLines(stockPrices));
        stockPrices = new int[][]{{1,1},{500000000,499999999},{1000000000,999999998}};
        System.out.println(minimumLines(stockPrices));
        stockPrices = new int[][]{{72,98},{62,27},{32,7},{71,4},{25,19},{91,30},{52,73},{10,9},{99,71},{47,22},{19,30},{80,63},{18,15},{48,17},{77,16},{46,27},{66,87},{55,84},{65,38},{30,9},{50,42},{100,60},{75,73},{98,53},{22,80},{41,61},{37,47},{95,8},{51,81},{78,79},{57,95}};
        System.out.println(minimumLines(stockPrices));
    }

    /*
    Slop formula between 2 points
    (y2-y1)/(x2-x1)
    between 3 points
    (y2-y1)/(x2-x1) = (y3-y2)/(x3-x2)
     */
    static int minimumLines(int[][] stockPrices){
        int n = stockPrices.length;
        if(n ==1){
            return 0;
        }
        //Sort by X (day)
        Arrays.sort(stockPrices, Comparator.comparingInt(o -> o[0]));
        int count = 1;
        //Start from 3 points to calculate straight lines
        for(int i =2; i<n; i++){
            BigDecimal x1 = BigDecimal.valueOf(stockPrices[i][0]);
            BigDecimal x2 = BigDecimal.valueOf(stockPrices[i-1][0]);
            BigDecimal x3 = BigDecimal.valueOf(stockPrices[i-2][0]);
            BigDecimal y1 = BigDecimal.valueOf(stockPrices[i][1]);
            BigDecimal y2 = BigDecimal.valueOf(stockPrices[i-1][1]);
            BigDecimal y3 = BigDecimal.valueOf(stockPrices[i-2][1]);
            /*
            (y2-y1) = (y3-y2)
            -------   -------
            (x2-x1) = (x3-x2)

            (y2-y1) * (x3-x2) = (y3-y2) * (x2-x1)
             */
            BigDecimal d1 = (y2.subtract(y1)).multiply(x3.subtract(x2));
            BigDecimal d2 = (y3.subtract(y2)).multiply((x2.subtract(x1)));
            if(!d1.equals(d2)){
                count++;
            }

        }

        return count;
    }
}
