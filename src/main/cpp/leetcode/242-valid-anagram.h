#ifndef LEETCODE_EASY_ARRAYS_AND_HASHING_242_VALID_ANAGRAM_H_
#define LEETCODE_EASY_ARRAYS_AND_HASHING_242_VALID_ANAGRAM_H_

#include <string>
#include <unordered_map>

/*
  lesson: know how insert work and all other ways of inserting into map
  time: O(2n) => O(n)
  space: O(2n) => O(n)
 */

namespace leetcode {
class Solution {
public:
  bool IsAnagram(std::string& s, std::string& t) {
    if (s.size() != t.size()) return false;
    std::unordered_map<char, int> m;
    for (const char& c : s) {
      if (m.find(c) == m.end()) {
        m.insert({c, 1});
      }
      else {
        m[c] = m[c] + 1;
      }
    }
    for (const char& c: t) {
      if (m.find(c) == m.end() || m[c] == 0)  return false;
      m[c] = m[c] - 1;
    }
    return true;
  }
};
} // namespace leetcode
#endif
