#ifndef LEETCODE_MEDIUM_ARRAYS_128_LONGEST_CONSECUTIVE_SEQUENCE_H_
#define LEETCODE_MEDIUM_ARRAYS_128_LONGEST_CONSECUTIVE_SEQUENCE_H_

#include <vector>
#include <unordered_set>

// Time: O(n)
// Space: O(n)
// rip. couldn't solve

namespace leetcode {
class Solution {
 public:
  
  int LongestConsecutiveSequence(const std::vector<int>& nums) {
    std::unordered_set<int> vertices;
    for (auto num : nums) {
      vertices.insert(num);
    }
    int length = 0;
    for (auto num : nums) {
      if (vertices.find(num-1) == vertices.end()) {
        int i = num+1;
        while (vertices.find(i) != vertices.end()) {
          i++;
        }
        length = std::max(length, i-num);
      }
    }
    return length;
  }
  
};

} // namespace leetcode

#endif
