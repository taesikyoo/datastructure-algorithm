package section16quicksort;

public class SortColors {

    public static void main(String[] args) {
        System.out.println(sortColors(new int[]{2, 0, 2, 1, 1, 0}));
    }

    public static int[] sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int num : nums) {
            counts[num]++;
        }
        for (int num : nums) {

        }
        return nums;
    }


}
