package section5;

public class maxSubarraySum {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{100, 200, 300, 400}, 2));
        System.out.println(solution(new int[]{1, 4, 2, 10, 23, 3, 1, 0, 20}, 4));
        System.out.println(solution(new int[]{-3, 4, 0, -2, 6, -1}, 2));
        System.out.println(solution(new int[]{3, -2, 7, -4, 1, -1, 4, -2, 1}, 2));
        System.out.println(solution(new int[]{2, 3}, 3));
    }

    private static int solution(int[] arr, int length) {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += arr[i];
        }
        int maxSum = sum;

        int index = length;
        while (index < arr.length) {
            sum -= arr[index - length];
            sum += arr[index];
            index++;
            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        return maxSum;
    }

}
