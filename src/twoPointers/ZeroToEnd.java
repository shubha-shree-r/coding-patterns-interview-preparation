package twoPointers;

import java.util.Arrays;

//Given an array of integers, modify the array in place to move all zeros to the end while maintaining
// the relative order of non-zero elements.
//Example:
//
//Input: nums = [0, 1, 0, 3, 2]
//Output: [1, 3, 2, 0, 0]
public class ZeroToEnd {

    public static int[] moveZeroes(int[] nums) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
        return nums;

    }

    public static void main(String[] args) {
        int[] input = {0, 1, 0, 3, 0,2,0};
        System.out.println(Arrays.toString(moveZeroes(input)));
    }
}
