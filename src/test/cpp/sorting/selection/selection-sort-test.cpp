#include "sorting/selection/selection-sort.h"

#include "gtest/gtest.h"

TEST(SelectionSort, FirstExample) {
  std::vector<int> input{2,3,4,1};
  algorithms::SelectionSort algo;
  std::vector<int> expected{1,2,3,4};
  ASSERT_EQ(expected, algo.sort(input));
}
