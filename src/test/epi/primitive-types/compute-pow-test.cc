#include "src/main/cc/data-structures-and-algorithms/primitive-types/compute-pow.h"

#include "gtest/gtest.h"

TEST(ComputePow, FirstExample) {
  epi::ComputePow algo;
  ASSERT_EQ(8, algo.pow(2,3));
}
