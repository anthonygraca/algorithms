#ifndef ALGORITHMS_PRINCETON_SORTING_MERGE_SORT_BOTTOM_UP_H_
#define ALGORITHMS_PRINCETON_SORTING_MERGE_SORT_BOTTOM_UP_H_

#include <vector>

namespace algorithms {
class MergeSortBU {
  public:
    std::vector<int> sort(std::vector<int>& input) {
      for (int len = 1; len < input.size(); len *= 2) {
        for (int low = 0; low < input.size()-len; low += len+len) {
          merge(input, low, low+len-1, std::min<int>(low+len+len-1, input.size()-1));
        }
      }
      return input;
    }

    std::vector<int> merge(std::vector<int>& a, int low, int mid, int high) {
      int i = low;
      int j = mid+1;
      std::vector<int> new_vector;
      for (auto element : a) {
        new_vector.push_back(element);
      }
      for (int k = low; k <= high; k++) {
        if (i > mid) a[k] = new_vector[j++];
        else if (j > high) a[k] = new_vector[i++];
        else if (new_vector[j] < new_vector[i]) a[k] = new_vector[j++];
        else a[k] = new_vector[i++];
      }
      return a;
    }
};
} // namespace algorithms

#endif
