#include <leetcode/130-surrounded-regions.h>

#include <vector>

#include <gtest/gtest.h>

TEST(SurroundedRegions, FirstExample) {
  std::vector<std::vector<char>> board {
    {'X','X','X','X'},
    {'X','O','O','X'},
    {'X','X','O','X'},
    {'X','O','X','X'}
  };
  leetcode::Solution solution;
  solution.solve(board);
  std::vector<std::vector<char>> expected {
    {'X','X','X','X'},
    {'X','X','X','X'},
    {'X','X','X','X'},
    {'X','O','X','X'}
  };
  for (int i = 0; i < board.size(); i++) {
    for (int j = 0; j < board[i].size(); j++) {
      EXPECT_EQ(expected[i][j], board[i][j]);
    }
  }
}

TEST(SurroundedRegions, SecondExample) {
  std::vector<std::vector<char>> board {
    {'X'}
  };
  leetcode::Solution solution;
  solution.solve(board);
  EXPECT_EQ(board, board);
}
