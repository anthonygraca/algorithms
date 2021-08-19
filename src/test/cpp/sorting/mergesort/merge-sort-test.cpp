#include "sorting/mergesort/merge-sort.h"

#include "gtest/gtest.h"

TEST(MergeSort, FirstExample) {
  std::vector<int> input{2,3,4,1};
  algorithms::MergeSort algo;
  std::vector<int> expected{1,2,3,4};
  ASSERT_EQ(expected, algo.sort(input));
}
