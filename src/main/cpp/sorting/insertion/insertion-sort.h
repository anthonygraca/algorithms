#ifndef ALGORITHMS_PRINCETON_SORTING_INSERTION_H_
#define ALGORITHMS_PRINCETON_SORTING_INSERTION_H_

#include <vector>

namespace algorithms {
class InsertionSort {
  public:
    std::vector<int> sort(std::vector<int> input) {
      int n = input.size();
      for (int i = 1; i < n; i++) {
        for (int j = i; j > 0 && input[j] < input[j-1]; j--) {
          std::swap(input[j], input[j-1]);
        }
      }
      return input;
    }
};
} //  namespace algorithms
#endif
