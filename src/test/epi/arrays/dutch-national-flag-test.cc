#include "src/main/cc/data-structures-and-algorithms/arrays/dutch-national-flag.h"

#include "gtest/gtest.h"

#include <vector>

TEST(DutchNationalFlag, FirstExample) {
  std::vector<int> input{0,1,2,0,2,1,1};
  int pivot_index = 3;
  epi::DutchNationalFlag algo;
  algo.partition(pivot_index, input);
  std::vector<int> expected{0,0,2,2,1,1,1};
  ASSERT_EQ(expected, input);
}

TEST(DutchNationalFlag, SecondExample) {
  std::vector<int> input{0,1,2,0,2,1,1};
  int pivot_index = 2;
  epi::DutchNationalFlag algo;
  algo.partition(pivot_index, input);
  std::vector<int> expected{0,1,0,1,1,2,2};
  ASSERT_EQ(expected, input);
}

TEST(DutchNationalFlag, ThirdExample) {
  std::vector<int> input{0,1,2,0,2,1,1};
  int pivot_index = 1;
  epi::DutchNationalFlag algo;
  algo.partition(pivot_index, input);
  std::vector<int> expected{0,0,1,1,1,2,2};
  ASSERT_EQ(expected, input);
}
