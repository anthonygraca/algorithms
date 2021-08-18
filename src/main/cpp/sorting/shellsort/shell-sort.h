#ifndef ALGORITHMS_PRINCETON_SORTING_SHELL_SORT_H_
#define ALGORITHMS_PRINCETON_SORTING_SHELL_SORT_H_

#include <vector>

namespace algorithms {
class ShellSort {
  public:
    std::vector<int> sort(std::vector<int> input) {
      int n = input.size();
      int h = 1;
      while (h < n/2) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
      while (h >= 1) { // h-sort the array
        for (int i = h; i < n; i++) { 
          // Insert input[i] amoung a[i-h], a[i-2*h], a[i-3*h], ... 
          for (int j = i; j >= h && input[j] < input[j-h]; j -=h) {
            int temp = input[j];
            input[j] = input[j-h];
            input[j-h] = temp;
          }
        }
        h = h/3;
      }
      return input;
    }
};
} // namespace algorithms

#endif
