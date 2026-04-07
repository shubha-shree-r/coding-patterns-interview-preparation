package hashMapsAndSets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class ZeroStriping {
    public static int[][] setZeroesSet(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        // Step 1: Store indices
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        // Step 2: Update matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        System.out.println(Arrays.deepToString(setZeroesSet(matrix)));


    }
}



