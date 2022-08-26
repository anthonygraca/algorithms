#include <leetcode/238-product-of-array-except-self.h>

#include <vector>

#include <gtest/gtest.h>

TEST(ProductOfArrayExceptSelf, FirstExample) {
  std::vector<int> nums{1,2,3,4};
  std::vector<int> expected{24,12,8,6};
  leetcode::Solution s;
  std::vector<int> output = s.ProductExceptSelf(nums);
  EXPECT_EQ(expected[0], output[0]);
  EXPECT_EQ(expected[1], output[1]);
  EXPECT_EQ(expected[2], output[2]);
  EXPECT_EQ(expected[3], output[3]);
}

TEST(ProductOfArrayExceptSelf, SecondExample) {
  std::vector<int> nums{-1,1,0,-3,3};
  std::vector<int> expected{0,0,9,0,0};
  leetcode::Solution s;
  std::vector<int> output = s.ProductExceptSelf(nums);
  EXPECT_EQ(expected[0], output[0]);
  EXPECT_EQ(expected[1], output[1]);
  EXPECT_EQ(expected[2], output[2]);
  EXPECT_EQ(expected[3], output[3]);
}

// -1,1,0,-3,3]
