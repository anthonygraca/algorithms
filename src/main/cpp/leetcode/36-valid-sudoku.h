#ifndef LEETCODE_MEDIUM_ARRAYS_AND_HASHING_36_VALID_SUDOKU_H_
#define LEETCODE_MEDIUM_ARRAYS_AND_HASHING_36_VALID_SUDOKU_H_

/*
  if n == board
  Time Complexity: O(n) where n = 9x9
  Space Complexity: O(3m) => O(m) where m = 9
  time to solve: 10 minutes initally. +10 minutes to implement 3x3 case,
                 +5 minutes to figure out correct offset formula.
 */

#include <unordered_set>
#include <vector>

namespace leetcode {
class Solution {
 public:
  bool IsValidSudoku(std::vector<std::vector<char>>& board) {
    
    std::vector<std::unordered_set<char>> rows(
        board.size(), std::unordered_set<char>());
    std::vector<std::unordered_set<char>> cols(
        board.size(), std::unordered_set<char>());
    std::vector<std::unordered_set<char>> grid(
        board.size(), std::unordered_set<char>());
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char digit = board[i][j];
        if (digit != '.') {
          bool dup_row = rows[i].find(digit) != rows[i].end();
          bool dup_col = cols[j].find(digit) != cols[j].end();
          /*
            0 1 2
            3 4 5
            6 7 8
           */
          int loc = (i/3 * 3) + j/3;
          bool dup_grid = grid[loc].find(digit) != cols[loc].end();
          if (dup_row || dup_col || dup_grid) {
            return false;
          }
          else {
            rows[i].insert(digit);
            cols[j].insert(digit);
            grid[loc].insert(digit);
          }
        }
      }
    }
    return true;
  }

};
} // namespace leetcode
#endif
