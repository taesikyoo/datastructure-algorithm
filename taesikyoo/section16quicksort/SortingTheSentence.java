package section16quicksort;

import java.util.HashMap;
import java.util.Map;

public class SortingTheSentence {

    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
    }

    public static String sortSentence(String s) {
        String[] wordArr = s.split(" ");
        int[] indexArr = new int[wordArr.length];
        Map<Integer, String> wordMap = new HashMap<>();
        for (int i = 0; i < wordArr.length; i++) {
            String word = wordArr[i];
            int lastIndex = word.length() - 1;
            int index = Integer.parseInt(String.valueOf(word.charAt(lastIndex)));
            indexArr[i] = index;
            wordMap.put(index, word.substring(0, lastIndex));
        }

        QuickSort.sort(indexArr);
        StringBuilder sb = new StringBuilder();
        return s;
    }
}
