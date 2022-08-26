#ifndef LEETCODE_EASY_TWO_POINTERS_125_VALID_PALINDROME_H_
#define LEETCODE_EASY_TWO_POINTERS_125_VALID_PALINDROME_H_

#include <string>
#include <cctype>

// Time: O(n)
// Space: O(1)
// solved : 20 minutes. didn't read problem closely and got caught on edge cases
// lesson; know cctype library for isalnum() and tolower(). get sleep.

namespace leetcode {
class Solution {
 public:
  bool IsPalindrome(std::string s) {
    
    int size = s.size();
    // odd or even?
    int left = 0;
    int right = size-1;
    while (left < right) {
      while (!isalnum(s[left])) {
        left++;
        if (left > right) return true;
      }
      while (!isalnum(s[right])) {
        right--;
        if (left > right) return true;
      }
      if (std::tolower(s[left]) != std::tolower(s[right])) {
        return false;
      }
      left++;
      right--;
    }
    return true;
    
  }
};
} // namespace leetcode
#endif
