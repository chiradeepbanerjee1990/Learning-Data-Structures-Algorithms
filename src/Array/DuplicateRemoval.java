package Array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Chiradeep Banerjee
 * Email : chiradeep.banerjee72@gmail.com.
 * <p>
 * Consider an array of duplicates that individual numbers are less than the length of the array
 */
public class DuplicateRemoval {

    /**
     * Using extra space but Complexity O(n)
     *
     * @param array
     */

    public static void returnDuplicates(int[] array) {
        //Sort the array
        Arrays.sort(array);
        HashSet<Integer> myMap = new HashSet<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (i + 1 < array.length && array[i] == array[i + 1]) {
                myMap.add(array[i]);
            }
        }
        for (Integer i : myMap)
            System.out.print("\n" + i);

    }


    /**
     * Not using extra space but Complexity O(n)
     *
     * @param array
     */

    public static void returnDuplicateswithoutExtraMemory(int[] array) {

        for (int i = 0; i < array.length; i++) {
            array[Math.abs(array[i])] = -array[Math.abs(array[i])];
            System.out.print("\n================");
        }
        for (int j = 0; j < array.length; j++) {
            if (array[j] < 0) System.out.print("\nDuplicate number: " + Math.abs(array[j]));
        }
    }


    public static void main(String args[]) {
        int given[] = new int[]{2, 3, 1, 2, 4, 3};
        returnDuplicates(given);
        returnDuplicateswithoutExtraMemory(given);
    }
}
