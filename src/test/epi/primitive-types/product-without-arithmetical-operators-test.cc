#include "src/main/cc/data-structures-and-algorithms/primitive-types/product-without-arithmetical-operators.h"

#include "gtest/gtest.h"

TEST(ProductWithoutArithmeticalOperators, FirstExample) {
  epi::ProductWithoutArithmeticalOperators algo;
  ASSERT_EQ(6, algo.product(2,3));
}

TEST(ProductWithoutArithmeticalOperators, SecondExample) {
  epi::ProductWithoutArithmeticalOperators algo;
  ASSERT_EQ(256, algo.product(16,16));
}

TEST(ProductWithoutArithmeticalOperators, SecondExampleInBinary) {
  epi::ProductWithoutArithmeticalOperators algo;
  ASSERT_EQ(0b100000000, algo.product(0b10000,0b10000));
}

TEST(ProductWithoutArithmeticalOperators, ThirdExample) {
  epi::ProductWithoutArithmeticalOperators algo;
  ASSERT_EQ(240, algo.product(16,15));
}

TEST(ProductWithoutArithmeticalOperators, ThirdExampleInBinary) {
  epi::ProductWithoutArithmeticalOperators algo;
  ASSERT_EQ(0b11110000, algo.product(0b10000,0b1111));
}

TEST(ProductWithoutArithmeticalOperators, FourthExample) {
  epi::ProductWithoutArithmeticalOperators algo;
  ASSERT_EQ(117, algo.product(13,9));
}
