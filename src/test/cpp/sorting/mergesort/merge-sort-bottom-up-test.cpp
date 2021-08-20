#include "sorting/mergesort/merge-sort-bottom-up.h"

#include "gtest/gtest.h"

TEST(MergeSortBottomUp, FirstExample) {
  std::vector<int> input{2,3,4,1};
  algorithms::MergeSortBU algo;
  std::vector<int> expected{1,2,3,4};
  ASSERT_EQ(expected, algo.sort(input));
}
