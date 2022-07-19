#include "src/main/cc/data-structures-and-algorithms/primitive-types/counting-bits.h"

#include "gtest/gtest.h"

#include <vector>

TEST(CountingBits, ZerothExample) {
  epi::CountingBits algo;
  ASSERT_EQ(0, algo.countBits(0));
}

TEST(CountingBits, FirstExample) {
  epi::CountingBits algo;
  ASSERT_EQ(1, algo.countBits(1));
}

TEST(CountingBits, SecondExample) {
  epi::CountingBits algo;
  ASSERT_EQ(1, algo.countBits(2));
}

TEST(CountingBits, ThirdExample) {
  epi::CountingBits algo;
  ASSERT_EQ(2, algo.countBits(3));
}

TEST(CountingBits, FourthExample) {
  epi::CountingBits algo;
  ASSERT_EQ(1, algo.countBits(4));
}

TEST(CountingBits, FifthExample) {
  epi::CountingBits algo;
  ASSERT_EQ(2, algo.countBits(5));
}

TEST(CountingBits, SixthExample) {
  epi::CountingBits algo;
  ASSERT_EQ(2, algo.countBits(6));
}

TEST(CountingBits, SeventhExample) {
  epi::CountingBits algo;
  ASSERT_EQ(3, algo.countBits(7));
}

TEST(CountingBits, EighthExample) {
  epi::CountingBits algo;
  ASSERT_EQ(1, algo.countBits(8));
}

TEST(CountingBits, NinthExample) {
  epi::CountingBits algo;
  ASSERT_EQ(2, algo.countBits(9));
}

TEST(CountingBits, TenthExample) {
  epi::CountingBits algo;
  ASSERT_EQ(2, algo.countBits(10));
}

TEST(CountingBits, EleventhExample) {
  epi::CountingBits algo;
  ASSERT_EQ(3, algo.countBits(11));
}

TEST(CountingBits, TwelfthExample) {
  epi::CountingBits algo;
  ASSERT_EQ(2, algo.countBits(12));
}

TEST(CountingBits, ThirteenthExample) {
  epi::CountingBits algo;
  ASSERT_EQ(3, algo.countBits(13));
}

TEST(CountingBits, FourteenthExample) {
  epi::CountingBits algo;
  ASSERT_EQ(3, algo.countBits(14));
}

TEST(CountingBits, FifteenthExample) {
  epi::CountingBits algo;
  ASSERT_EQ(4, algo.countBits(15));
}

TEST(CountingBits, SixteenthExample) {
  epi::CountingBits algo;
  ASSERT_EQ(1, algo.countBits(16));
}

TEST(CountingBits, SeventeenthExample) {
  epi::CountingBits algo;
  ASSERT_EQ(2, algo.countBits(17));
}

TEST(CountingBits, EighteenthExample) {
  epi::CountingBits algo;
  ASSERT_EQ(2, algo.countBits(18));
}
