#include <leetcode/417-pacific-atlantic-water-flow.h>

#include <vector>

#include <gtest/gtest.h>

TEST(PacificAtlanticWaterFlow, FirstExample) {
  std::vector<std::vector<int>> heights{
    {1,2,2,3,5},
    {3,2,3,4,4},
    {2,4,5,3,1},
    {6,7,1,4,5},
    {5,1,1,2,4}
  };
  leetcode::Solution solution;
  std::vector<std::vector<int>> coord = solution.pacificAtlantic(heights);
  std::vector<std::vector<int>> expected{
    {0,4}, {1,3}, {1,4}, {2,2}, {3,0}, {3,1}, {4,0}
  };
  EXPECT_EQ(expected[0], coord[0]);
  EXPECT_EQ(expected[1], coord[1]);
  EXPECT_EQ(expected[2], coord[2]);
  EXPECT_EQ(expected[3], coord[3]);
  EXPECT_EQ(expected[4], coord[4]);
  EXPECT_EQ(expected[5], coord[5]);
  EXPECT_EQ(expected[6], coord[6]);
}

TEST(PacificAtlanticWaterFlow, SecondExample) {
  std::vector<std::vector<int>> heights{
    {2,1},
    {1,2}
  };
  leetcode::Solution solution;
  std::vector<std::vector<int>> coord = solution.pacificAtlantic(heights);
  std::vector<std::vector<int>> expected{
    {0,0}, {0,1}, {1,0}, {1,1}
  };
  EXPECT_EQ(expected[0], coord[0]);
  EXPECT_EQ(expected[1], coord[1]);
  EXPECT_EQ(expected[2], coord[2]);
  EXPECT_EQ(expected[3], coord[3]);
}

TEST(PacificAtlanticWaterFlow, ThirdExample) {
  std::vector<std::vector<int>> heights{
    {3,3,3,3,3,3},
    {3,0,3,3,0,3},
    {3,3,3,3,3,3}
  };
  leetcode::Solution solution;
  std::vector<std::vector<int>> coord = solution.pacificAtlantic(heights);
  std::vector<std::vector<int>> expected{
    {0,0},{0,1},{0,2},{0,3},{0,4},{0,5},{1,0},{1,2},{1,3},{1,5},{2,0},{2,1},{2,2},{2,3},{2,4},{2,5}
  };
  EXPECT_EQ(expected[0], coord[0]);
  EXPECT_EQ(expected[1], coord[1]);
  EXPECT_EQ(expected[2], coord[2]);
  EXPECT_EQ(expected[3], coord[3]);
  EXPECT_EQ(expected[4], coord[4]);
}



TEST(PacificAtlanticWaterFlow, FourthExample) {
  std::vector<std::vector<int>> heights{
    {1,2,3,4},
    {12,13,14,5},
    {11,16,15,6},
    {10,9,8,7}

  };
  leetcode::Solution solution;
  std::vector<std::vector<int>> coord = solution.pacificAtlantic(heights);
  std::vector<std::vector<int>> expected{
    {0,3},{1,0},{1,1},{1,2},{1,3},{2,0},{2,1},{2,2},{2,3},{3,0},{3,1},{3,2},{3,3}
  };
  EXPECT_EQ(expected[0], coord[0]);
  EXPECT_EQ(expected[1], coord[1]);
  EXPECT_EQ(expected[2], coord[2]);
  EXPECT_EQ(expected[3], coord[3]);
  EXPECT_EQ(expected[4], coord[4]);
  EXPECT_EQ(expected[5], coord[5]);
  EXPECT_EQ(expected[6], coord[6]);
  EXPECT_EQ(expected[7], coord[7]);
  EXPECT_EQ(expected[8], coord[8]);
  EXPECT_EQ(expected[9], coord[9]);
  EXPECT_EQ(expected[10], coord[10]);
  EXPECT_EQ(expected[11], coord[11]);
  EXPECT_EQ(expected[12], coord[12]);
}

