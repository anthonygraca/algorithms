#include "sorting/quicksort/quick-sort.h"

#include "gtest/gtest.h"

TEST(QuickSort, FirstExample) {
  std::vector<int> input{2,3,4,1};
  algorithms::QuickSort algo;
  std::vector<int> expected{1,2,3,4};
  ASSERT_EQ(expected, algo.sort(input));
}
