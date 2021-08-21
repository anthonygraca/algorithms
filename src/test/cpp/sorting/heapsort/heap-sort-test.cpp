#include "sorting/heapsort/heap-sort.h"

#include "gtest/gtest.h"

TEST(HeapSort, FirstExample) {
  std::vector<int> input{2,3,4,1};
  algorithms::HeapSort algo;
  std::vector<int> expected{1,2,3,4};
  ASSERT_EQ(expected, algo.sort(input));
}
