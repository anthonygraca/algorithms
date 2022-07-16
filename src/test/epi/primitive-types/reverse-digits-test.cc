#include "src/main/cc/data-structures-and-algorithms/primitive-types/reverse-digits.h"

#include "gtest/gtest.h"

TEST(ReverseDigits, FirstExample) {
  epi::ReverseDigits algo;
  ASSERT_EQ(1123, algo.reverse(3211));
}
