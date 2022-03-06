package section15mergesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[]{1, 10, 50}, new int[]{2, 14, 99, 100})));

        System.out.println(Arrays.toString(mergeSort(new int[]{10, 4, 76, 73}, 4)));
    }

    public static int[] mergeSort(int[] a, int n) {
        if (n < 2) {
            return a;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        return merge(a, l, r, mid, n - mid);
    }

    public static int[] merge(
        int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }

        return a;
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr2[j] < arr1[i]) {
                result.add(arr2[j]);
                j++;
            } else {
                result.add(arr1[i]);
                i++;
            }
        }

        while (i < arr1.length) {
            result.add(arr1[i]);
            i++;
        }
        while (j < arr2.length) {
            result.add(arr2[j]);
            j++;
        }

        return result.stream()
            .mapToInt(in -> in)
            .toArray();
    }
}
