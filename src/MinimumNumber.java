public class MinimumNumber {
    public static void main(String[] args) {
        System.out.println(solve(28,97,32));
    }

    static int solve(int A, int B, int C) {
        StringBuilder sb = new StringBuilder();
        int min = Math.min(A, Math.min(B, C));
        int max = Math.max(A, Math.max(B, C));
        int mid = A + B +C -min - max;
        sb.append(min).append(mid).append(max);
        return Integer.parseInt(sb.toString());
    }
}
