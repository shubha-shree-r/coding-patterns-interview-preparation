package hashMapsAndSets;
import java.util.HashSet;

  public class LongestConsecutive {

        public static int longestConsecutive(int[] nums) {
            HashSet<Integer> set = new HashSet<>();

            // Add all elements to set
            for (int num : nums) {
                set.add(num);
            }

            int longest = 0;

            for (int num : set) {
                // Check if it's the start of a sequence
                if (!set.contains(num - 1)) {
                    int currentNum = num;
                    int count = 1;

                    // Expand the sequence
                    while (set.contains(currentNum + 1)) {
                        currentNum++;
                        count++;
                    }

                    longest = Math.max(longest, count);
                }
            }

            return longest;
        }

        public static void main(String[] args) {
            int[] nums = {100, 1, 200, 6, 3, 2,5,10,9,8,7,4,80};
            System.out.println("Longest Consecutive Sequence Length: " + longestConsecutive(nums));
        }
    }


