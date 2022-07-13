#include <leetcode/997-rotting-oranges.h>

#include <vector>

#include <gtest/gtest.h>

TEST(RottingOranges, FirstExample) {
  std::vector<std::vector<int>> grid {
    {2,1,1},
    {1,1,0},
    {0,1,1}
  };
  leetcode::Solution solution;
  int result = solution.orangesRotting(grid);
  EXPECT_EQ(4, result);
}

TEST(RottingOranges, SecondExample) {
  std::vector<std::vector<int>> grid {
    {2,1,1},
    {0,1,1},
    {1,0,1}
  };
  leetcode::Solution solution;
  int result = solution.orangesRotting(grid);
  EXPECT_EQ(-1, result);
}

TEST(RottingOranges, ThirdExample) {
  std::vector<std::vector<int>> grid {
    {0,2},
  };
  leetcode::Solution solution;
  int result = solution.orangesRotting(grid);
  EXPECT_EQ(0, result);
}

TEST(RottingOranges, FourthExample) {
  std::vector<std::vector<int>> grid {
    {0}
  };
  leetcode::Solution solution;
  int result = solution.orangesRotting(grid);
  EXPECT_EQ(0, result);
}

TEST(RottingOranges, FifthExample) {
  std::vector<std::vector<int>> grid {
    {1}
  };
  leetcode::Solution solution;
  int result = solution.orangesRotting(grid);
  EXPECT_EQ(-1, result);
}

TEST(RottingOranges, SixthExample) {
  std::vector<std::vector<int>> grid {
    {2,0,2,2,2,0,0,1,2},
    {1,2,1,1,0,2,2,0,2},
    {0,0,0,0,1,2,0,1,0},
    {1,2,2,2,2,2,1,2,0},
    {2,0,0,0,2,2,2,1,2},
    {2,1,2,0,1,0,0,2,2},
    {0,2,2,2,2,0,2,2,2},
    {1,2,1,1,0,1,1,1,2},
    {0,0,0,1,1,2,0,1,2},
    {0,2,2,1,2,1,2,1,1}
  };
  leetcode::Solution solution;
  int result = solution.orangesRotting(grid);
  EXPECT_EQ(2, result);
}


