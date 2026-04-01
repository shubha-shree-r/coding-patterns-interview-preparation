package twoPointers;
//Given an array of integers sorted in ascending order and a target value, return the indexes of any pair of numbers in the array that sum to the target. The order of the indexes in the result doesn't matter. If no pair is found, return an empty array.
//Example 1:
//
//Input: nums = [-5, -2, 3, 4, 6], target = 7
//Output: [2, 3]
//Explanation: nums[2] + nums[3] = 3 + 4 = 7
//
//Example 2:
//
//Input: nums = [1, 1, 1], target = 2
//Output: [0, 1]
//Explanation: other valid outputs could be [1, 0], [0, 2], [2, 0], [1, 2] or [2, 1].


import java.util.ArrayList;
import java.util.Arrays;

public class PairSumSorted {

      public static ArrayList<Integer> pairSum(ArrayList<Integer> nums, int target){
          int left = 0;
          int right = nums.size() - 1;

          while(left < right){
              int sum = nums.get(left) + nums.get(right);

              if(sum < target){
                  left++;
              }else if(sum > target){
                  right--;
              }else{
                  ArrayList<Integer> result = new ArrayList<>();
                  result.add(left);
                  result.add(right);
                  return result;

              }
          }
          return new ArrayList<>();
      }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1,1,1));
        int target = 2;

        System.out.println(pairSum(input, target));
    }
}
