#ifndef LEETCODE_MEDIUM_ARRAYS_AND_HASHING_49_GROUP_ANAGRAMS_H_
#define LEETCODE_MEDIUM_ARRAYS_AND_HASHING_49_GROUP_ANAGRAMS_H_

#include <string>
#include <unordered_map>
#include <vector>

// time: O(n*mlogm), n for going through input * mlogm for sorting string
// space: O(n), 2n for map, n for output
// time to solve: 10 minutes.
// need to know: std::sort

namespace leetcode {
class Solution {
 public:
  std::vector<std::vector<std::string>>
  GroupAnagrams(std::vector<std::string>& strs) {
    // map from sorted str to correct
    std::unordered_map<std::string, std::vector<std::string>> map;
    // sort then insert index to map
    for (int i = 0; i < strs.size(); i++) {
      std::string str = strs[i];
      std::sort(str.begin(), str.end());
      if (map.find(str) == map.end()) {
        map.insert({str, std::vector<std::string>{strs[i]}});
      }
      else {
        (map.at(str)).push_back(strs[i]);
      }
    }
    std::vector<std::vector<std::string>> anagrams;
    for (const auto& e : map) {
      anagrams.push_back(e.second);
    }
    return anagrams;
  }
};
} // namespace leetcode 
#endif
