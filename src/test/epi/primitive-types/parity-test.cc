#include "src/main/cc/data-structures-and-algorithms/primitive-types/parity.h"

#include "gtest/gtest.h"

TEST(Parity, FirstExample) {
  epi::Parity algo;
  ASSERT_EQ(1, algo.parity(0b1011));
}

TEST(Parity, SecondExample) {
  epi::Parity algo;
  ASSERT_EQ(0, algo.parity(0b10001000));
}
