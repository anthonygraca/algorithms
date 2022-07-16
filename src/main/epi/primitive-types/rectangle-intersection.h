#ifndef EPI_SRC_MAIN_DATA_STRUCTURES_AND_ALGORITHMS_PRIMITIVE_TYPES_RECTANGLE_INTERSECTION_H_
#define EPI_SRC_MAIN_DATA_STRUCTURES_AND_ALGORITHMS_PRIMITIVE_TYPES_RECTANGLE_INTERSECTION_H_

/*
 * Write a program that tests if two rectangles have a nonempty intersection. If
 * the intersection is nonempty, return the rectangle formed by the
 * intersection.
 */

#include <algorithm>

namespace epi {

struct Rect {
  int x, y, width, height;
};

class RectangleIntersection {
public:
  Rect IntersectRectangle(const Rect& a, const Rect& b) {
    if (!isIntersect(a, b)) {
      return {0,0,-1,-1};
    }
    return {std::max(a.x, b.x),
            std::max(a.y, b.y),
            std::min(a.x + a.width, b.x + b.width) - std::max(a.x, b.x),
            std::min(a.y + a.height, b.y + b.height) - std::max(a.y, b.y)};
  }

  bool isIntersect(const Rect& a, const Rect& b) {
    return a.x <= b.x + b.width && b.x <= a.x + a.width &&
           a.y <= b.y + b.height && b.y <= a.y + a.height;
    
  }
};
} // namespace epi

#endif
