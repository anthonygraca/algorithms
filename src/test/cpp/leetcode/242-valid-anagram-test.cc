#include <leetcode/242-valid-anagram.h>

#include <string>

#include <gtest/gtest.h>

TEST(ValidAnagram, FirstExample) {
  std::string s{"anagram"};
  std::string t{"nagaram"};
  leetcode::Solution sol;
  EXPECT_TRUE(sol.IsAnagram(s, t));
}

TEST(ValidAnagram, SecondExample) {
  std::string s{"rat"};
  std::string t{"car"};
  leetcode::Solution sol;
  EXPECT_FALSE(sol.IsAnagram(s, t));
}
