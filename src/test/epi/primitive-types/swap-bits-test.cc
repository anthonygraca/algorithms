#include "src/main/cc/data-structures-and-algorithms/primitive-types/swap-bits.h"

#include "gtest/gtest.h"

TEST(SwapBits, FirstExample) {
  epi::SwapBits algo;
  ASSERT_EQ(1, algo.swap_bits(8, 0, 3));
}

TEST(SwapBits, DISABLED_SecondExample) {
  epi::SwapBits algo;
  ASSERT_EQ(1, algo.swap_bits(16, 1, 4));
}

TEST(SwapBits, DISABLED_ThirdExample) {
  epi::SwapBits algo;
  ASSERT_EQ(16, algo.swap_bits(1, 1, 4));
}
