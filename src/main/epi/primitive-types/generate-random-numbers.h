#ifndef EPI_SRC_MAIN_DATA_STRUCTURES_AND_ALGORITHMS_PRIMITIVE_TYPES_GENERATE_RANDOM_NUMBERS_H_
#define EPI_SRC_MAIN_DATA_STRUCTURES_AND_ALGORITHMS_PRIMITIVE_TYPES_GENERATE_RANDOM_NUMBERS_H_

/*
 * How would you implement a random number generator that generates a random
 * integer i between a and b, inclusive, given a random number generator that
 * produces zero or one with equal probability?
 */

#include <chrono>
#include <random>

namespace epi {
class GenerateRandomNumbers {
public:
  int generateRandom(int lower_bound, int upper_bound) {
    int range = upper_bound - lower_bound + 1;
    int result = 0;
    do {
      result = 0;
      for (int i = 0; (1 << i) < range; i++) {
        result = result | (getZeroOrOne() << i);
      }
    } while (result > range);
    return result + lower_bound;
  }

  int getZeroOrOne() {
    unsigned seed = std::chrono::system_clock::now().time_since_epoch().count();
    std::default_random_engine generator(seed);
    std::uniform_int_distribution<int> random(0,1);
    return random(generator);
  }
};
} // namespace epi

#endif
