/**
 * {2, 1, 5, 3, 6, 4, 8, 9, 7} => 5 ({1,3,4,8,9} or {2,5,6,8,9})
 */
public class LongestIncreasingSubsequence {

    //O(n^2)
    public static int lis1(int[] data) {
        int[] d = new int[data.length];
        int maxLen = 1;

        for (int i = 0; i < data.length; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (data[i] > data[j])
                    d[i] = Math.max(d[i], d[j] + 1);
            }

            if (d[i] > maxLen) maxLen = d[i];
        }

        return maxLen;
    }

    /*
    O(nlogn)
    -----------------------------------------
    data = {2, 1, 5, 3, 6, 4, 8, 9, 7}
    -----------------------------------------
    helper
    {2}              <- 1
    {1}              <- 5
    {1,5}            <- 3
    {1,3}            <- 6
    {1,3,5}          <- 4
    {1,3,4}          <- 8
    {1,3,4,8}        <- 9
    {1,3,4,8,9}      <- 7
    {1,3,4,7,9}
    -----------------------------------------
    => 5
    */
    public static int lis2(int[] data) {
        int[] helper = new int[data.length];
        int k = 0;
        helper[0] = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] >= helper[k])
                helper[++k] = data[i];
            else {
                int pos = binarySearch(helper, data[i], k);
                helper[pos] = data[i];
            }
        }
        return k + 1;
    }

    public static int binarySearch(int[] data, int num, int k) {
        int beg = 0;
        int end = k;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            if (num >= data[mid])
                beg = mid + 1;
            else
                end = mid - 1;
        }
        return beg;
    }

    public static void main(String[] args) {
        int[] data = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        int res = lis1(data);
        System.out.println(res);
    }
}
