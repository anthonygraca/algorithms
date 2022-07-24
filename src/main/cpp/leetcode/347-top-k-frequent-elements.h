#ifndef LEETCODE_MEDIUM_ARRAYS_AND_HASHING_347_TOP_K_FREQUENT_ELEMENTS_H_
#define LEETCODE_MEDIUM_ARRAYS_AND_HASHING_347_TOP_K_FREQUENT_ELEMENTS_H_

#include <vector>
#include <unordered_map>

// how to sort a std::pair? lambda?
// 13~ minutes

// Time : Naive is O(nlogn) ->  O(n) with buckets
// Space : O(n)

namespace leetcode {
class Solution {
 public:
  std::vector<int> GetTopKFrequent(std::vector<int>& nums, int k) {
    
    std::unordered_map<int, int> map; // map from element to frequency
    for (const int& element : nums) {
      if (map.find(element) == map.end()) {
        map.insert({element, 1});
      }
      else {
        map[element] = map[element] + 1;
      }
    }
    // bucket of freq to element
    std::vector<std::vector<int>> bucket(nums.size()+1, std::vector<int>());
    for (auto [e, freq] : map) {
      bucket[freq].push_back(e);
    }
    std::vector<int> solution;
    for (int i = nums.size(); k>0; i--) {
      for (auto e : bucket[i]) {
        solution.push_back(e);
        k--;
      }
    }
    return solution;
  }
  
};

} // namespace leetcode

#endif
