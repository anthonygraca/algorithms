#include <leetcode/1-two-sum.h>

#include <vector>

#include <gtest/gtest.h>

TEST(TwoSum, FirstExample) {
  std::vector<int> nums{2,7,11,15};
  int target{9};
  std::vector<int> expected{0,1};
  leetcode::Solution s;
  auto output = s.TwoSum(nums, target);
  EXPECT_EQ(expected[0], output[0]);
  EXPECT_EQ(expected[1], output[1]);
}

TEST(TwoSum, SecondExample) {
  std::vector<int> nums{3,2,4};
  int target{6};
  std::vector<int> expected{1,2};
  leetcode::Solution s;
  auto output = s.TwoSum(nums, target);
  EXPECT_EQ(expected[0], output[0]);
  EXPECT_EQ(expected[1], output[1]);
}

TEST(TwoSum, ThirdExample) {
  std::vector<int> nums{3,3};
  int target{6};
  std::vector<int> expected{1,0};
  leetcode::Solution s;
  auto output = s.TwoSum(nums, target);
  EXPECT_EQ(expected[0], output[0]);
  EXPECT_EQ(expected[1], output[1]);
}
