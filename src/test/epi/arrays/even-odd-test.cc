#include "src/main/cc/data-structures-and-algorithms/arrays/even-odd.h"

#include "gtest/gtest.h"

#include <vector>

TEST(EvenOddArrays, FirstExample) {
  std::vector<int> input{1,2,3,4,5,6,7,8,9,10};
  epi::EvenOdd algo;
  algo.partition(input);
  for (int i = 0; i < input.size()/2; i++) {
    ASSERT_TRUE(input[i] % 2 == 0);
  }
  for (int i = input.size()/2; i < input.size(); i++) {
    ASSERT_FALSE(input[i] % 2 == 0);
  }
}
