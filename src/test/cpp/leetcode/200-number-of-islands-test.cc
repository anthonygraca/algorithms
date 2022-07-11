#include <leetcode/200-number-of-islands.h>

#include <vector>

#include <gtest/gtest.h>

TEST(NumberOfIslands, FirstExample) {
  std::vector<std::vector<char>> grid = {
    {'1','1','1','1','0'},
    {'1','1','0','1','0'},
    {'1','1','0','0','0'},
    {'0','0','0','0','0'}
  };
  leetcode::NumberOfIslands solution;
  EXPECT_EQ(1, solution.solve(grid));
}

TEST(NumberOfIslands, SecondExample) {
  std::vector<std::vector<char>> grid = {
    {'1','1','0','0','0'},
    {'1','1','0','0','0'},
    {'0','0','1','0','0'},
    {'0','0','0','1','1'}
  };
  leetcode::NumberOfIslands solution;
  EXPECT_EQ(3, solution.solve(grid));
}
