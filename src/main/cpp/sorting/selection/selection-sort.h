#ifndef ALGORITHMS_PRINCETON_SORTING_SELECTION_H_
#define ALGORITHMS_PRINCETON_SORTING_SELECTION_H_

#include <vector>

namespace algorithms {
class SelectionSort {
  public:
    std::vector<int> sort(std::vector<int> input) {
      int n = input.size();
      for (int i = 0; i < n; i++) {
        int min = i;
        for (int j = i+1; j < n; j++) {
          if (input[j] < input[min]) min = j;
        }
        int temp = input[i];
        input[i] = input[min];
        input[min] = temp;
      }
      return input;
    };
};
} // namespace algorithms

#endif
