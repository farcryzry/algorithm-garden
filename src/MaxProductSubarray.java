/**
 * Maximum Product Subarray
 */
public class MaxProductSubarray {
    // n
    public static int mps1(int[] data) {
        if (data == null || data.length == 0) return 0;

        int max_local = data[0];
        int min_local = data[0];
        int global = data[0];

        for (int i = 1; i < data.length; i++) {
            int max_copy = max_local;
            max_local = Math.max(Math.max(data[i] * max_local, data[i]), data[i] * min_local);
            min_local = Math.min(Math.min(data[i] * max_copy, data[i]), data[i] * min_local);
            global = Math.max(global, max_local);
        }

        return global;
    }

    public static void main(String args[]) {
        int[] data = {2, 3, -2, 4};
        int res = mps1(data);
        System.out.println(res);
    }
}
