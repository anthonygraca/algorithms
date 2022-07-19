#include "src/main/cc/data-structures-and-algorithms/primitive-types/decimal-palindrome.h"

#include "gtest/gtest.h"

TEST(DecimalPalindrome, FirstExample) {
  epi::DecimalPalindrome algo;
  ASSERT_TRUE(algo.isPalindrome(321123));
}

TEST(DecimalPalindrome, SecondExample) {
  epi::DecimalPalindrome algo;
  ASSERT_TRUE(algo.isPalindrome(32123));
}

TEST(DecimalPalindrome, ThirdExample) {
  epi::DecimalPalindrome algo;
  ASSERT_FALSE(algo.isPalindrome(3123));
}

TEST(DecimalPalimdrome, FourthExample) {
  epi::DecimalPalindrome algo;
  ASSERT_TRUE(algo.isPalindrome(1));
}

TEST(DecimalPalindrome, FifthExample) {
  epi::DecimalPalindrome algo;
  ASSERT_FALSE(algo.isPalindrome(12));
}

TEST(DecimalPalindrome, SixthExample) {
  epi::DecimalPalindrome algo;
  ASSERT_FALSE(algo.isPalindrome(123));
}

TEST(DecimalPalindrome, SeventhExample) {
  epi::DecimalPalindrome algo;
  ASSERT_TRUE(algo.isPalindrome(3223));
}
