#include "sorting/shellsort/shell-sort.h"

#include "gtest/gtest.h"

TEST(ShellSort, FirstExample) {
  std::vector<int> input{2,3,4,1};
  algorithms::ShellSort algo;
  std::vector<int> expected{1,2,3,4};
  ASSERT_EQ(expected, algo.sort(input));
}
