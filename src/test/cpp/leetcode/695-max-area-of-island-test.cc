#include <leetcode/695-max-area-of-island.h>

#include <vector>

#include <gtest/gtest.h>

TEST(MaxAreaOfIsland, FirstExample) {
  std::vector<std::vector<int>> grid{
    {0,0,1,0,0,0,0,1,0,0,0,0,0},
    {0,0,0,0,0,0,0,1,1,1,0,0,0},
    {0,1,1,0,1,0,0,0,0,0,0,0,0},
    {0,1,0,0,1,1,0,0,1,0,1,0,0},
    {0,1,0,0,1,1,0,0,1,1,1,0,0},
    {0,0,0,0,0,0,0,0,0,0,1,0,0},
    {0,0,0,0,0,0,0,1,1,1,0,0,0},
    {0,0,0,0,0,0,0,1,1,0,0,0,0}
  };
  leetcode::Solution solution;
  int result = solution.maxAreaOfIsland(grid);
  EXPECT_EQ(6, result);
}

TEST(MaxAreaOfIsland, SecondExample) {
  std::vector<std::vector<int>> grid{{0,0,0,0,0,0,0,0}};
  leetcode::Solution solution;
  int result = solution.maxAreaOfIsland(grid);
  EXPECT_EQ(0, result);
}
