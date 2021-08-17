#include "sorting/insertion/insertion-sort.h"

#include "gtest/gtest.h"

TEST(InsertionSort, FirstExample) {
  std::vector<int> input{2,3,4,1};
  algorithms::InsertionSort algo;
  std::vector<int> expected{1,2,3,4};
  ASSERT_EQ(expected, algo.sort(input));
}
