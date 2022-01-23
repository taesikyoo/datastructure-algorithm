package section5;

public class minSubArrayLen {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 3, 1, 2, 4, 3}, 7)); // 2
    }

    private static int solution(int[] nums, int sum) {
        int total = 0;
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;

        while (start < nums.length) {
            // if current window doesn't add up to the given sum then
            // move the window to right
            if (total < sum && end < nums.length) {
                total += nums[end];
                end++;
            }
            // if current window adds up to at least the sum given then
            // we can shrink the window
            else if (total >= sum) {
                minLen = Math.min(minLen, end - start);
                total -= nums[start];
                start++;
            }
            // current total less than required total but we reach the end, need this or else we'll be in an infinite loop
            else {
                break;
            }
        }

        return minLen;
    }

}
