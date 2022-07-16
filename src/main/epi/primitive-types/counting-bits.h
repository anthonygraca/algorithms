#ifndef ELEMENTS_OF_PROGRAMMING_INTERVIEWS_DATA_STRUCTURES_AND_ALGORITHMS_PRIMITIVE_TYPES_COUNTING_BITS_H_
#define ELEMENTS_OF_PROGRAMMING_INTERVIEWS_DATA_STRUCTURES_AND_ALGORITHMS_PRIMITIVE_TYPES_COUNTING_BITS_H_

/*
 * For a given positive integer, count the number of bits that are set to 1.
 */

#include <vector>

namespace epi {
class CountingBits {
public:
  int countBits(uint32_t n) {
    int count{0};
    while (n >= 1) { // the runtime is O(k), where k == number of 1s
      count += 1;
      n = n & (n-1);
    }
    return count;
  }
};
} // namespace epi

#endif
