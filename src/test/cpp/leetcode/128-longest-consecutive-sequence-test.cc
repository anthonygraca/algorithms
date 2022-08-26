#include <leetcode/128-longest-consecutive-sequence.h>

#include <vector>

#include <gtest/gtest.h>

TEST(LongestConsecutiveSequence, First) {
  std::vector<int> nums{100,4,200,1,3,2};
  leetcode::Solution s;
  int output = s.LongestConsecutiveSequence(nums);
  EXPECT_EQ(4, output);
}

TEST(LongestConsecutiveSequence, Second) {
  std::vector<int> nums{0,3,7,2,5,8,4,6,0,1};
  leetcode::Solution s;
  int output = s.LongestConsecutiveSequence(nums);
  EXPECT_EQ(9, output);
}
