package hashMapsAndSets;

import java.util.HashMap;
import java.util.Map;

public class GeometricSequence {

    public static long countTriplets(int[] arr, int r) {
        Map<Long, Long> leftMap = new HashMap<>();
        Map<Long, Long> rightMap = new HashMap<>();

        // Step 1: Fill rightMap with frequency
        for (int num : arr) {
            rightMap.put((long) num, rightMap.getOrDefault((long) num, 0L) + 1);
        }

        long count = 0;

        // Step 2: Traverse array
        for (int num : arr) {
            long val = num;

            // Decrease current from rightMap (since it's now middle)
            rightMap.put(val, rightMap.get(val) - 1);

            // Check if valid middle
            if (val % r == 0) {
                long left = leftMap.getOrDefault(val / r, 0L);
                long right = rightMap.getOrDefault(val * r, 0L);

                count += left * right;
            }

            // Add current to leftMap
            leftMap.put(val, leftMap.getOrDefault(val, 0L) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4};
        int r = 2;

        System.out.println("Triplets count: " + countTriplets(arr, r));
    }
}
