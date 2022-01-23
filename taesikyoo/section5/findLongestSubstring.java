package section5;

import java.util.HashMap;
import java.util.Map;

public class findLongestSubstring {

    public static void main(String[] args) {
        System.out.println(solution("rithmschool"));
        System.out.println(solution("thecatinthehat"));
    }

    private static int solution(String str) {
        int longest = 0;
        Map<Character, Integer> seen = new HashMap<>();
        int start = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.toCharArray()[i];
            if (seen.containsKey(ch)) {
                start = Math.max(start, seen.get(ch));
            }
            // index - beginning of substring + 1 (to include current in count)
            longest = Math.max(longest, i - start + 1);
            // store the index of the next char so as to not double count
            seen.put(ch, i + 1);
        }
        return longest;
    }
}
