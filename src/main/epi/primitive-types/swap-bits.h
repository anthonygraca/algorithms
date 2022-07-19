#ifndef EPI_SRC_MAIN_DATA_STRUCTURES_AND_ALGORITHMS_PRIMITIVE_TYPES_SWAP_BITS_H_
#define EPI_SRC_MAIN_DATA_STRUCTURES_AND_ALGORITHMS_PRIMITIVE_TYPES_SWAP_BITS_H_

/*
 * A 64-bit integer can be viewed as an array of 64 bits, with the bit at index
 * 0 corresponding to the lest significant bit (LSB), and the bit at index 63
 * corresponding to the most significant bit (MSB). Implement code that takes as
 * input a 64-bit integer and swaps the bits at indices i and j.
 */

#include <stdint.h>

namespace epi {
class SwapBits {
public:
  int swap_bits(uint32_t number, int i, int j) {
    if (((number >> i) & 1) != ((number >> j) & 1)) {
      auto bitmask = (1 << i) | (1 << j);
      number ^= bitmask;
    }
    return number;
  }
};
} // namespace epi

#endif
