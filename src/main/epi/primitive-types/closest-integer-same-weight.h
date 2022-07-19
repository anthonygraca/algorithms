#ifndef EPI_SRC_MAIN_DATA_STRUCTURES_AND_ALGORITHMS_PRIMITIVE_TYPES_CLOSEST_INTEGER_SAME_WEIGHT_H_
#define EPI_SRC_MAIN_DATA_STRUCTURES_AND_ALGORITHMS_PRIMITIVE_TYPES_CLOSEST_INTEGER_SAME_WEIGHT_H_

/*
 * Define the weight of a nonnegative integer x to be the number of bits that
 * are set to 1 in its binary representation. For example, since 92 in base-2
 * equals 0b1011100, the weight of 92 is 4.
 *
 * Write a program which takes an input a nonnegative integer x and returns a
 * number y which is not equal to x, but has the same weight as x and their
 * difference, |y - x|, is as small as possible. You can assume x is not 0, or
 * all 1s. For example, if x 6, you should return 5.
 *
 * Hint: Start with the least significant bit.
 */

#include <stdexcept>

namespace epi {
class ClosestIntegerSameWeight {
public:
  unsigned long long closestIntSameBitCount(unsigned long long x) {
    for(int i = 0; i < 64-1; i++) {
      if (((x >> i) & 1) != ((x >> (i + 1)) & 1)) {
        x ^= (1 << i) | (1 << (i + 1));
        return x;
      }
    }
    throw std::invalid_argument("All bits are 0 or 1");
  }
};
} // namespace epi

#endif
