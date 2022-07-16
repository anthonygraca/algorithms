#ifndef EPI_SRC_MAIN_DATA_STRUCTURES_AND_ALGORITHMS_PRIMITIVE_TYPES_QUOTIENT_WITHOUT_ARITHMETICAL_OPERATORS_H_
#define EPI_SRC_MAIN_DATA_STRUCTURES_AND_ALGORITHMS_PRIMITIVE_TYPES_QUOTIENT_WITHOUT_ARITHMETICAL_OPERATORS_H_

namespace epi {
class QuotientWithoutArithmeticalOperators {
public:
  int quotient(int x, int y) {
    int result = 0;
    int power = 32;
    unsigned long long y_power = static_cast<unsigned long long>(y) << power;
    while (x >= y) {
      while (y_power > x) {
        y_power >>= 1;
        --power;
      }
      result += 1 << power;
      x -= y_power;
    }
    return result;
  }
};
} // namespace epi

#endif
