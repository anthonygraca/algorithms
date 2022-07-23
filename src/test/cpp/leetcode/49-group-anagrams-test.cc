#include <leetcode/49-group-anagrams.h>

#include <string>
#include <vector>

#include <gtest/gtest.h>

TEST(GroupAnagrams, FirstExample) {
  std::vector<std::string> strs {"eat","tea","tan","ate","nat","bat"};
  std::vector<std::vector<std::string>> expected {{"bat"},
                                                {"nat","tan"},
                                                {"ate","eat","tea"}};
  leetcode::Solution s;
  std::vector<std::vector<std::string>> output = s.GroupAnagrams(strs);
  /*
  EXPECT_EQ(expected[0][0], output[0][0]);
  EXPECT_EQ(expected[1][0], output[1][0]);
  EXPECT_EQ(expected[1][1], output[1][1]);
  EXPECT_EQ(expected[2][0], output[2][0]);
  EXPECT_EQ(expected[2][1], output[2][1]);
  EXPECT_EQ(expected[2][2], output[2][2]);
  */
}

TEST(GroupAnagrams, SecondExample) {
  std::vector<std::string> strs {};
  std::vector<std::vector<std::string>> expected {};
  leetcode::Solution s;
  std::vector<std::vector<std::string>> output = s.GroupAnagrams(strs);
  EXPECT_EQ(expected.size(), output.size());
}

TEST(GroupAnagrams, ThirdExample) {
  std::vector<std::string> strs {"a"};
  std::vector<std::vector<std::string>> expected {{"a"}};
  leetcode::Solution s;
  std::vector<std::vector<std::string>> output = s.GroupAnagrams(strs);
  EXPECT_EQ(expected[0][0], output[0]);
}
