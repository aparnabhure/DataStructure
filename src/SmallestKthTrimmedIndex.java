import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//https://leetcode.com/contest/weekly-contest-302/problems/query-kth-smallest-trimmed-number/
public class SmallestKthTrimmedIndex {
    public static void main(String[] args) {
        print(smallestTrimmed(new String[]{"8331019423839036903", "2215783497319194533","3244863164120264914","2723857887888553250",
                "1069645833408356268","3799170975306313470","3300849027471666477","8896469467436127218","9595084104356246555",
                "4601424390471226348","2777623221871959897","2660664761264162910","4830224756337097853","2239177595019260973",
                "5704104074606481922","5158962343348888307","4957489822885409209","5533958195540658313","6712811206814843536",
                "9775503283462317096","1975389311819120035","1292135637676764140","9838972337538013522","7609294617007602893",
                "0186572359592634437","9236053726818307461","7264888050655615544","4990296885039745852","1417868535147288083"}
            , new int[][]{{22,19},{16,17},{10,7},{27,16},{9,9},{21,4},{24,2},{12,11},{2,5},{24,12},{25,7},{7,13},{14,9},{23,15},{18,17},{22,16},{4,14},{14,17},{25,11},{12,16},{29,3},{22,11},{29,2},{24,2},{24,15},{7,14},{7,3},{7,14},{1,3}}));

        print(smallestTrimmed(new String[]{"64333639502","65953866768","17845691654","87148775908","58954177897","70439926174","48059986638","47548857440","18418180516","06364956881","01866627626","36824890579","14672385151","71207752868"}
            , new int[][]{{9,4},{6,1},{3,8},{12,9},{11,4},{4,9},{2,7},{10,3},{13,1},{13,1},{6,1},{5,10}}));
        print(smallestTrimmed(new String[]{"24","37","96","04"}, new int[][]{{2,1},{2,2}}));
        print(smallestTrimmed(new String[]{"102","473","251","814"}, new int[][]{{1,1},{2,3},{4,2},{1,2}}));


        //This solution doesn't work for string size 100 TLE
        print(smallestTrimmedNumbers(new String[]{"8331019423839036903","2215783497319194533","3244863164120264914","2723857887888553250","1069645833408356268","3799170975306313470","3300849027471666477","8896469467436127218","9595084104356246555","4601424390471226348","2777623221871959897","2660664761264162910","4830224756337097853","2239177595019260973","5704104074606481922","5158962343348888307","4957489822885409209","5533958195540658313","6712811206814843536","9775503283462317096","1975389311819120035","1292135637676764140","9838972337538013522","7609294617007602893","0186572359592634437","9236053726818307461","7264888050655615544","4990296885039745852","1417868535147288083"}
        , new int[][]{{22,19},{16,17},{10,7},{27,16},{9,9},{21,4},{24,2},{12,11},{2,5},{24,12},{25,7},{7,13},{14,9},{23,15},{18,17},{22,16},{4,14},{14,17},{25,11},{12,16},{29,3},{22,11},{29,2},{24,2},{24,15},{7,14},{7,3},{7,14},{1,3}}));
        print(smallestTrimmedNumbers(new String[]{"64333639502","65953866768","17845691654","87148775908","58954177897","70439926174","48059986638","47548857440","18418180516","06364956881","01866627626","36824890579","14672385151","71207752868"}
        , new int[][]{{9,4},{6,1},{3,8},{12,9},{11,4},{4,9},{2,7},{10,3},{13,1},{13,1},{6,1},{5,10}}));
        print(smallestTrimmedNumbers(new String[]{"24","37","96","04"}, new int[][]{{2,1},{2,2}}));
        int[] result = smallestTrimmedNumbers(new String[]{"102","473","251","814"}, new int[][]{{1,1},{2,3},{4,2},{1,2}});
        print(result);


    }

    static void print(int[] result){
        for(int i: result){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static int[] smallestTrimmed(String[] nums, int[][] queries){
        int q = queries.length;
        int[] result = new int[q];

        int n = nums[0].length();

        int i =0;
        for(int[] query: queries) {

            int trim = query[1];
            List<Item> items = new ArrayList<>();
            for(int x =0; x< nums.length; x++){
                String num = nums[x];
                if(trim<n){
                    //trim
                    num = num.substring(n-trim);
                }
                items.add(new Item(x, num));
            }

            int k = query[0];
            //Find the kth smallest element
            Comparator<Item> byValue = Comparator.comparing(Item::getElement);
            items.sort(byValue);
            int smallestKthElementIndex = items.get(k-1).index;
            result[i] = smallestKthElementIndex;
            i++;
        }

        return result;
    }

    static class Item{
        String element;
        int index;
        public Item(int index, String element){
            this.index = index;
            this.element = element;
        }
        public String getElement(){
            return element;
        }
    }

    static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int q = queries.length;
        int[] result = new int[q];

        int n = nums[0].length();

        int i =0;
        for(int[] query: queries){
            int k = query[0];
            int trim = query[1];
            List<BigInteger> trims = new ArrayList<>();

            for(String num: nums){
                if(trim<n){
                    //trim
                    num = num.substring(n-trim);
                }
                trims.add(new BigInteger(num));
            }

            //Find kth smallest number index
            int index = findKthSmallestNumber(trims, k);
            result[i] = index;
            i++;

        }


        return result;

    }

    static int findKthSmallestNumber(List<BigInteger> trims, int k){
        BigInteger[] v = new BigInteger[k];
        int[] idx = new int[k];
        for(int i=0; i<k; i++){
            v[i]= BigInteger.valueOf(-1);
            idx[i]=-1;
        }

        int n = trims.size();

        for(int i=0; i<n; i++){
            BigInteger num = trims.get(i);

            for(int j=0; j<k; j++){
                if(v[j].compareTo(BigInteger.valueOf(-1)) == 0){
                    v[j] = num;
                    idx[j] = i;
                    break;
                }else if(num.compareTo(v[j]) < 0 ){
                    //swap elements
                    for(int x=k-1; x>=j+1; x--){
                        v[x] = v[x-1];
                        idx[x] = idx[x-1];
                    }
                    v[j] = num;
                    idx[j] = i;
                    break;
                }

            }


        }

        return idx[k-1];

    }
}
