#ifndef EPI_SRC_MAIN_DATA_STRUCTURES_AND_ALGORITHMS_ARRAYS_DUTCH_NATIONAL_FLAG_H_
#define EPI_SRC_MAIN_DATA_STRUCTURES_AND_ALGORITHMS_ARRAYS_DUTCH_NATIONAL_FLAG_H_

#include <vector>

namespace epi {
class DutchNationalFlag {
public:
  std::vector<int> partition(int pivot_index, std::vector<int>& input) {
    int smaller = 0;
    int middle = 0;
    int bigger = input.size() - 1;
    int pivot_value = input[pivot_index];

    while (middle <= bigger) {
      if (input[middle] < pivot_value) {
        std::swap(input[smaller], input[middle]);
        smaller++;
        middle++;
      }
      else if (input[middle] == pivot_value) {
        middle++;
      }
      else { // if (input[i] > pivot_value) 
        std::swap(input[bigger], input[middle]);
        bigger--;
      }
    }

    return input;
  }
};
} // namespace epi

#endif
