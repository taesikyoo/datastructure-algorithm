package section15mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CountSmaller {

    public static void main(String[] args) {
        System.out.println(countSmaller(new int[]{5, 2, 6, 1}));
    }

    public static List<Integer> countSmaller(int[] nums) {
        List<Pair> numAndCount = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numAndCount.add(new Pair(nums[i]));
        }

        List<Pair> pairs = mergeSort(numAndCount, numAndCount.size());
        return pairs.stream()
            .map(pair -> pair.count)
            .collect(Collectors.toList());
    }

    static class Pair {

        int value;
        int count;

        public Pair(int value) {
            this.value = value;
            this.count = 0;
        }
    }

    public static List<Pair> mergeSort(List<Pair> a, int n) {
        if (n < 2) {
            return a;
        }
        int mid = n / 2;
        List<Pair> l = new ArrayList<>();
        List<Pair> r = new ArrayList<>();

        for (int i = 0; i < mid; i++) {
            l.add(a.get(i));
        }
        for (int i = mid; i < n; i++) {
            r.add(a.get(i));
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        return merge(a, l, r, mid, n - mid);
    }

    public static List<Pair> merge(
        List<Pair> a, List<Pair> l, List<Pair> r, int left, int right) {

/*        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l.get(i).value <= r.get(j).value) {
                a.add(k, l.get(i));
                i++;
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }*/

        return a;
    }
}
