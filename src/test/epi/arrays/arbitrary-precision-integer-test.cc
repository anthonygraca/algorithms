#include "src/main/epi/arrays/arbitrary-precision-integer.h"

#include "gtest/gtest.h"

#include <vector>

TEST(IncrementArbitraryPrecisionInteger, FirstExample) {
  std::vector<int> input{1,2,9};
  epi::ArbitraryPrecisionInteger algo;
  std::vector<int> expected{1,3,0};
  ASSERT_EQ(expected, algo.increment(input));
}

TEST(IncrementArbitraryPrecisionInteger, SecondExample) {
  std::vector<int> input{9};
  epi::ArbitraryPrecisionInteger algo;
  std::vector<int> expected{1,0};
  ASSERT_EQ(expected, algo.increment(input));
}

TEST(IncrementArbitraryPrecisionInteger, ThirdExample) {
  std::vector<int> input{8};
  epi::ArbitraryPrecisionInteger algo;
  std::vector<int> expected{9};
  ASSERT_EQ(expected, algo.increment(input));
}
