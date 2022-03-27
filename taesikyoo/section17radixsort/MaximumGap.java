package section17radixsort;

public class MaximumGap {

    public static void main(String[] args) {
        int[] arr = {3, 6, 9, 1};
        System.out.println(getMaxGap(arr));
    }

    private static int getMaxGap(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }

        RadixSort.sort(arr);

        int maxGap = 0;
        for (int i = 1; i < arr.length; i++) {
            maxGap = Math.max(maxGap, arr[i] - arr[i - 1]);
        }

        return maxGap;
    }

}
