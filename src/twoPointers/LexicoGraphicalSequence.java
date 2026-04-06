package twoPointers;

public class LexicoGraphicalSequence {
    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'd'};

        nextPermutation(arr);

        System.out.println(new String(arr));
    }

    public static void nextPermutation(char[] arr) {
        int n = arr.length;

        // Step 1: Find breakpoint (i such that arr[i] < arr[i+1])
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // Step 2: If breakpoint found
        if (i >= 0) {
            int j = n - 1;

            // Find next greater element from right
            while (arr[j] <= arr[i]) {
                j--;
            }

            // Swap
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // Step 3: Reverse the right part
        reverse(arr, i + 1, n - 1);
    }

    public static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}