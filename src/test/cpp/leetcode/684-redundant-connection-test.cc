#include <leetcode/684-redundant-connection.h>

#include <vector>

#include <gtest/gtest.h>

TEST(RedundantConnection, FirstExample) {
  std::vector<std::vector<int>> edges {
    {1,2}, {1,3}, {2,3}
  };
  leetcode::Solution s;
  std::vector<int> remove = s.findRedundantConnection(edges);
  EXPECT_EQ(2, remove[0]);
  EXPECT_EQ(3, remove[1]);
}

TEST(RedundantConnection, SecondExample) {
  std::vector<std::vector<int>> edges {
    {1,2}, {2,3}, {3,4}, {1,4}, {1,5}
  };
  leetcode::Solution s;
  std::vector<int> remove = s.findRedundantConnection(edges);
  EXPECT_EQ(1, remove[0]);
  EXPECT_EQ(4, remove[1]);
}
