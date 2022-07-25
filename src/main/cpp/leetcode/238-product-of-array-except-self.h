#ifndef LEETCODE_MEDIUM_ARRAYS_AND_HASHING_238_PRODUCT_OF_ARRAY_EXCEPT_SELF_H_
#define LEETCODE_MEDIUM_ARRAYS_AND_HASHING_238_PRODUCT_OF_ARRAY_EXCEPT_SELF_H_

#include <vector>

// time to solve: 25 minutes
// learn how not to optimize too early

namespace leetcode {
class Solution {
 public:
  std::vector<int> ProductExceptSelf(std::vector<int>& nums) {
    std::vector<int> left(nums.size(), 1);
    for (int i = 1; i < nums.size(); i++) {
      left[i] = left[i-1] * nums[i-1];
    }
    int right_prod = 1;
    for (int i = nums.size()-2; i >= 0; i--) {
      right_prod = right_prod * nums[i+1];
      left[i] = left[i] * right_prod;
    }
    return left;
  }
};
} // namespace leetcode
#endif
