package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

//You are given an array of numbers, each representing the height of a vertical line on a graph. A container can be formed with any pair of these lines,
// along with the x-axis of the graph. Return the amount of water which the largest container can hold.
//Example:
//Input: heights = [2, 7, 8, 3, 7, 6]
//Output: 24
public class LargestContainer {

    public static int largest_container(ArrayList<Integer> heights) {
        int max_water = 0;
        int left = 0, right = heights.size() - 1;
        while (left < right) {
            // Calculate the water contained between the current pair of lines.
            int water = Math.min(heights.get(left), heights.get(right)) * (right - left);
            max_water = Math.max(max_water, water);
            // Move the pointers inward, always moving the pointer at the shorter line. If
            // both lines have the same height, move both pointers inward.
            if (heights.get(left) < heights.get(right)) {
                left++;
            } else if (heights.get(left) > heights.get(right)) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return max_water;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(2, 7, 8, 3, 7, 6));
        System.out.println(largest_container(input));
    }
}
