class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        solve(board);
    }

private:
    bool solve(vector<vector<char>>& board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Find an empty cell
                if (board[row][col] == '.') {
                    // Try digits '1' through '9'
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, row, col, c)) {
                            board[row][col] = c; // Place the digit
                            
                            // Recurse to solve the rest of the board
                            if (solve(board)) {
                                return true;
                            }
                            
                            board[row][col] = '.'; // Backtrack
                        }
                    }
                    return false; // No valid digit fits here, trigger backtracking
                }
            }
        }
        return true; // Entire board is filled successfully
    }

    bool isValid(vector<vector<char>>& board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // Check row constraint
            if (board[row][i] == c) return false;
            
            // Check column constraint
            if (board[i][col] == c) return false;
            
            // Check 3x3 sub-box constraint
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 4 == 0 ? 0 : i % 3; // Standard sub-box indexing trick
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        return true;
    }
};
