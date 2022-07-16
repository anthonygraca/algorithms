#include "src/main/cc/data-structures-and-algorithms/primitive-types/quotient-without-arithmetical-operators.h"

#include "gtest/gtest.h"

TEST(QuotientWithoutArithmeticalOperators, FirstExample) {
  epi::QuotientWithoutArithmeticalOperators algo;
  ASSERT_EQ(1, algo.quotient(3,2));
}

TEST(QuotientWithoutArithmeticalOperators, SecondExample) {
  epi::QuotientWithoutArithmeticalOperators algo;
  ASSERT_EQ(0, algo.quotient(2,3));
}
