package section17radixsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RadixSort {

    /*
     * https://www.baeldung.com/java-radix-sort
     */

    public static void main(String[] args) {
        int[] arr = {19, 28, 0, 29, 711, 19, 9, 4, 56, 112, 78, 41};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int numbers[]) {
        int maximumNumber = findMaximumNumberIn(numbers);

        int numberOfDigits = calculateNumberOfDigitsIn(maximumNumber);

        int placeValue = 1;

        while (numberOfDigits-- > 0) {
            applyCountingSortOn(numbers, placeValue);
            placeValue *= 10;
        }
    }

    private static void applyCountingSortOn(int[] numbers, int placeValue) {
        int range = 10; // radix or the base

        int length = numbers.length;
        int[] frequency = new int[range];
        int[] sortedValues = new int[length];

        for (int i = 0; i < length; i++) {
            int digit = (numbers[i] / placeValue) % range;
            frequency[digit]++;
        }

        for (int i = 1; i < range; i++) {
            frequency[i] += frequency[i - 1];
        }

        for (int i = length - 1; i >= 0; i--) {
            int digit = (numbers[i] / placeValue) % range;
            sortedValues[frequency[digit] - 1] = numbers[i];
            frequency[digit]--;
        }

        System.arraycopy(sortedValues, 0, numbers, 0, length);
    }

    private static int calculateNumberOfDigitsIn(int number) {
        return (int) Math.log10(number) + 1; // valid only if number > 0
    }

    private static int findMaximumNumberIn(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

    public static void radixSort(int[] nums) {
        int maxNum = findMaximumNumberIn(nums);
        int maxDigit = calculateNumberOfDigitsIn(maxNum);

        for (int k = 0; k < maxDigit; k++) {
            List<List<Integer>> bucketlists = new ArrayList<>();
            IntStream.range(0, 10)
                .forEach(i -> bucketlists.add(new ArrayList<>()));

            for (int i = 0; i < nums.length; i++) {
                int digit = getDigit(nums[i], k);
                bucketlists.get(digit).add(nums[i]);

                List<Integer> collect = bucketlists.stream()
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
                nums = collect.stream().mapToInt(n -> n).toArray();
            }

        }
    }

    private static int getDigit(int num, int k) {
        return (int) (Math.floor(Math.abs(num) / Math.pow(10, k)) % 10);
    }

}