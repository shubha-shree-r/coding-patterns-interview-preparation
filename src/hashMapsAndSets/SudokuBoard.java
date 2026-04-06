package hashMapsAndSets;

import java.util.HashSet;
import java.util.Set;

public class SudokuBoard {

    public static void main(String[] args) {
        int[][] board = {
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}
        };

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(int[][] board) {

        Set<Integer>[] rows = new HashSet[9];
        Set<Integer>[] cols = new HashSet[9];
        Set<Integer>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                int num = board[i][j];

                if (num == 0) continue;

                int boxIndex = (i / 3) * 3 + (j / 3);

                // Check row
                if (rows[i].contains(num)) return false;
                rows[i].add(num);

                // Check column
                if (cols[j].contains(num)) return false;
                cols[j].add(num);

                // Check box
                if (boxes[boxIndex].contains(num)) return false;
                boxes[boxIndex].add(num);
            }
        }

        return true;
    }
}