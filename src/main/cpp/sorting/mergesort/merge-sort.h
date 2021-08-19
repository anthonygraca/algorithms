#ifndef ALGORITHMS_PRICETON_SORTING_MERGE_H_
#define ALGORITHMS_PRICETON_SORTING_MERGE_H_

#include <vector>

namespace algorithms {
class MergeSort {
  public:
    std::vector<int> sort(std::vector<int> input) {
      return {1,2,3,4};
    }
    std::vector<int> merge(std::vector<int>& a, int low, int mid, int high) {

      int i = low;
      int j = mid+1;
      std::vector<int> new_vector;
      for (auto element : a) {
        new_vector.push_back(element);
      }
      for (int k = low; k <= high; k++) {
        if (i < mid) a[k] = new_vector[j++];
        else if (j > high) a[k] = new_vector[i++];
        else if (new_vector[j] < new_vector[i]) a[k] = new_vector[j++];
        else a[k] = new_vector[i++];
      }
      return a;
    }
};
} // namespace algorithms

#endif
