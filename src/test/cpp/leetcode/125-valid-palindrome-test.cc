#include <leetcode/125-valid-palindrome.h>

#include <string>

#include <gtest/gtest.h>

TEST(ValidPalindrome, First) {
  std::string str{"A man, a plan, a canal: Panama"};
  leetcode::Solution s;
  EXPECT_TRUE(s.IsPalindrome(str));
}


TEST(ValidPalindrome, Second) {
  std::string str{"race a car"};
  leetcode::Solution s;
  EXPECT_FALSE(s.IsPalindrome(str));
}

TEST(ValidPalindrome, Third) {
  std::string str{" "};
  leetcode::Solution s;
  EXPECT_TRUE(s.IsPalindrome(str));
}
