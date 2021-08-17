#include "sorting/insertion/insertion-sort.h"

#include "gtest/gtest.h"

TEST(InsertionSort, FirstExample) {
  algorithms::InsertionSort algo;
  ASSERT_EQ("abcde", algo.sort("bcdea"));
}
