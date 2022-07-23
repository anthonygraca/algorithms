#ifndef LEETCODE_EASY_ARRAYS_AND_HASHING_1_TWO_SUM_H_
#define LEETCODE_EASY_ARRAYS_AND_HASHING_1_TWO_SUM_H_

#include <unordered_map>
#include <vector>

// Time: O(n)
// Space: O(n)
// Time spent: 15 minutes. Got tripped up by non-existent edge cases

namespace leetcode {
class Solution {
public:
  std::vector<int> TwoSum(std::vector<int>& nums, int target) {
    std::unordered_map<int, int> m; // map from element to index
    for (int i = 0; i < nums.size(); i++) {
      m.insert({nums[i], i});
    }
    for (int i = 0; i < nums.size(); i++) {
      int other_operand = target - nums[i];
      if (m.find(other_operand) != m.end() && m.at(other_operand) != i) {
        return {i, m.at(other_operand)};
      }
    }
    return std::vector<int>();
  }
};
} // namespace leetcode

#endif
