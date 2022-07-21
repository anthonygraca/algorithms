#ifndef LEETCODE_EASY_ARRAYS_217_CONTAINS_DUPLICATE_H_
#define LEETCODE_EASY_ARRAYS_217_CONTAINS_DUPLICATE_H_

#include <vector>
#include <unordered_set>

namespace leetcode {
class Solution {
public:
  bool ContainsDuplicate(std::vector<int>& nums) {
    std::unordered_set<int> set;
    for (int n : nums) {
      set.insert(n);
    }
    return set.size() != nums.size();
  }
};
}
#endif
