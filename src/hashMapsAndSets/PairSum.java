package hashMapsAndSets;
//Given an array of integers, return the indexes of any two numbers that add up to a target. The order of the indexes in the result doesn't matter. If no pair is found, return an empty array.
//
//Example:
//
//Input: nums = [-1, 3, 4, 2], target = 3
//Output: [0, 2]
//Explanation: nums[0] + nums[2] = -1 + 4 = 3
//
//Constraints:
//
//The same index cannot be used twice in the result.
import java.util.HashMap;
import java.util.Map;

public class PairSum {
    public static void main(String[] args) {
        int[] nums = {-1, 3, 4, 2};
        int target = 3;

        int[] result = twoSum(nums, target);

        if (result.length == 0) {
            System.out.println("[]");
        } else {
            System.out.println("[" + result[0] + ", " + result[1] + "]");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{}; // empty array if no pair
    }
}