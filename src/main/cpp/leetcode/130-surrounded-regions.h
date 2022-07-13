#ifndef LEETCODE_MEDIUM_GRAPHS_130_SURROUNDED_REGIONS_H_
#define LEETCODE_MEDIUM_GRAPHS_130_SURROUNDED_REGIONS_H_

#include <vector>

namespace leetcode {
class Solution {
 public:
  
  void solve(std::vector<std::vector<char>>& board) {
    int n = board.size(), m = board[0].size();
    // traverse on left and right border
    for (int i = 0; i < n; i++) {
      if (board[i][0] == 'O') dfs(board, i, 0);
      if (board[i][m-1] == 'O') dfs(board, i, m-1);
    }

    // traverse on top and bottom border
    for (int j = 0; j < m; j++) {
      if (board[0][j] == 'O') dfs(board, 0, j);
      if (board[n-1][j] == 'O') dfs(board, n-1, j);
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == 'V') {
          board[i][j] = 'O';
        }
        else {
          board[i][j] = 'X';
        }
      }
    }
  }
  void dfs(std::vector<std::vector<char>>& board, int i, int j) {
    if (board[i][j] == 'O') {
      board[i][j] = 'V';
      // up
      if (i > 0 && board[i-1][j] == 'O') {
        dfs(board, i - 1, j);
      }
      // down
      if (i < board.size() - 1 && board[i+1][j] == 'O') {
        dfs(board, i + 1, j);
      }
      // left
      if (j > 0 && board[i][j-1] == 'O') {
        dfs(board, i, j-1);
      }
      // right
      if (j < board[0].size() - 1 && board[i][j+1] == 'O') {
        dfs(board, i, j+1);
      }
    }
  }
};
} // namespace leetcode

#endif
