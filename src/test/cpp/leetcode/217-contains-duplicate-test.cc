#include <leetcode/217-contains-duplicate.h>

#include <vector>

#include <gtest/gtest.h>

TEST(ContainsDuplicate, FirstExample) {
  std::vector<int> input{1,2,3,1};
  leetcode::Solution s;
  EXPECT_TRUE(s.ContainsDuplicate(input));
}

TEST(ContainsDuplicate, SecondExample) {
  std::vector<int> input{1,2,3,4};
  leetcode::Solution s;
  EXPECT_FALSE(s.ContainsDuplicate(input));
}

TEST(ContainsDuplicate, ThirdExample) {
  std::vector<int> input{1,1,1,3,3,4,3,2,4,2};
  leetcode::Solution s;
  EXPECT_TRUE(s.ContainsDuplicate(input));
}

