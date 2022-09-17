//https://leetcode.com/contest/biweekly-contest-87/problems/count-days-spent-together/
public class CountDaysSpentTogether {
    public static void main(String[] args) {
        System.out.println(countDaysTogether("08-06",
            "12-08",
            "02-04",
            "09-01"));
        System.out.println(countDaysTogether("08-15",
            "08-18",
            "08-16",
            "08-19"));
        System.out.println(countDaysTogether("09-01",
            "10-19",
            "06-19",
            "10-20"));
    }

    static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] md = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int aam = Integer.parseInt(arriveAlice.substring(0,2));
        int aad = Integer.parseInt(arriveAlice.substring(3,5));

        int alm = Integer.parseInt(leaveAlice.substring(0,2));
        int ald = Integer.parseInt(leaveAlice.substring(3,5));

        int bam = Integer.parseInt(arriveBob.substring(0,2));
        int bad = Integer.parseInt(arriveBob.substring(3,5));

        int blm = Integer.parseInt(leaveBob.substring(0,2));
        int bld = Integer.parseInt(leaveBob.substring(3,5));

        if(bam > alm || aam > blm){
            return 0;
        }

        int arrivingMonth = 0;
        int arrivingDays = 0;
        if(bam == aam){
            arrivingMonth = bam;
            arrivingDays = Math.max(bad, aad);
        }else if(bam > aam){
            arrivingMonth = bam;
            arrivingDays = bad;
        }else{
            arrivingMonth = aam;
            arrivingDays = aad;
        }

        int leavingMonth = 0;
        int leavingDays = 0;
        if(blm == alm){
            leavingMonth = blm;
            leavingDays = Math.min(bld, ald);
        }else if(blm < alm){
            leavingMonth = blm;
            leavingDays = bld;
        }else{
            leavingMonth = alm;
            leavingDays = ald;
        }

        if(leavingMonth == arrivingMonth){
            int days = leavingDays-arrivingDays+1;
            return Math.max(days, 0);
        }

        int sum = (md[arrivingMonth-1]-arrivingDays)+leavingDays;
        for(int i=arrivingMonth; i<leavingMonth-1; i++ ){
            sum += md[i];
        }
        return sum+1;

    }
}
