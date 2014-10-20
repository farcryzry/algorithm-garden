/**
 * max subarray
 */
public class MaxSubArray {

    // DP n
    public static int msa1(int[] A) {
        if (A == null || A.length == 0) return 0;

        int global = A[0];
        int local = A[0];

        for (int i = 1; i < A.length; i++) {
            local = Math.max(A[i], local + A[i]);
            global = Math.max(local, global);
        }

        return global;
    }

    // Divide and Conquer


    public static void main(String[] args) {
        //int[] data = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] data = {-2, -1};
        int res = msa1(data);
        System.out.println(res);
    }
}
