#include <leetcode/347-top-k-frequent-elements.h>

#include <vector>

#include <gtest/gtest.h>

TEST(TopKFrequentElements, FirstExample) {
  std::vector<int> nums {1,1,1,2,2,3};
  int k{2};
  leetcode::Solution s;
  std::vector<int> expected{1,2};
  auto output = s.GetTopKFrequent(nums, k);
  EXPECT_EQ(expected[0], output[0]);
  EXPECT_EQ(expected[1], output[1]);

}

TEST(TopKFrequentElements, SecondExample) {
  std::vector<int> nums {1};
  int k{1};
  leetcode::Solution s;
  std::vector<int> expected{1};
  auto output = s.GetTopKFrequent(nums, k);
  EXPECT_EQ(expected[0], output[0]);
}
