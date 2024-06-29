package how_many_are_smaller_than_me_II_3kyu;

/*
This is a hard version of How many are smaller than me?. If you have troubles solving
this one, have a look at the easier kata first.

Write

function smaller(arr)
that given an array arr, you have to return the amount of numbers that are smaller
than arr[i] to the right.

For example:

smaller([5, 4, 3, 2, 1]) === [4, 3, 2, 1, 0]
smaller([1, 2, 0]) === [1, 1, 0]
 */

import java.util.*;

public class Smaller {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(smaller(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(smaller(new int[]{5, 4, 7, 9, 2, 4, 1, 4, 5, 6})));
    }

    public static int[] smaller(int[] unsorted) {
        int[] result = new int[unsorted.length];
        Arrays.fill(result, 0);
        for (int i = 0; i < unsorted.length; i++) {
            for (int j = 0; j < i; j++) {
                if (unsorted[i] < unsorted[j]) result[j]++;
            }
        }
        return result;
    }

}
