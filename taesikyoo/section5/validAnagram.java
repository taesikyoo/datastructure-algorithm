package section5;

import java.util.HashMap;
import java.util.Map;

public class validAnagram {

    public static void main(String[] args) {
        System.out.println(solution("", ""));
        System.out.println(solution("amanaplanacanalpanama", "acanalmanplanpamana"));
        System.out.println(solution("rat", "car"));
        System.out.println(solution("texttwisttime", "timetwisttext"));
    }

    private static boolean solution(String s1, String s2) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c1 : s1.toCharArray()) {
            int value = frequencyMap.getOrDefault(c1, 0) + 1;
            frequencyMap.put(c1, value);
        }

        for (char c2 : s2.toCharArray()) {
            if (frequencyMap.containsKey(c2)) {
                Integer value = frequencyMap.get(c2);
                frequencyMap.put(c2, value - 1);
            } else {
                return false;
            }
        }

        return frequencyMap.keySet().stream()
            .allMatch(c -> {
                Integer integer = frequencyMap.get(c);
                return integer == 0;
            });
    }
}
