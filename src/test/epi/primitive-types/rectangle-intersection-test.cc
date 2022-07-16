#include "src/main/cc/data-structures-and-algorithms/primitive-types/rectangle-intersection.h"

#include "gtest/gtest.h"

TEST(RectangleIntersection, FirstExample) {
  epi::RectangleIntersection algo;
  epi::Rect expected{2,2,2,2};
  epi::Rect output = algo.IntersectRectangle({2,2,2,2}, {2,2,2,2});
  ASSERT_EQ(expected.x, output.x);
  ASSERT_EQ(expected.y, output.y);
  ASSERT_EQ(expected.width, output.width);
  ASSERT_EQ(expected.height, output.height);
}

TEST(RectangleIntersection, NoIntersection) {
  epi::RectangleIntersection algo;
  epi::Rect expected{0,0,-1,-1};
  epi::Rect output = algo.IntersectRectangle({2,2,2,2}, {5,5,2,2});
  ASSERT_EQ(expected.x, output.x);
  ASSERT_EQ(expected.y, output.y);
  ASSERT_EQ(expected.width, output.width);
  ASSERT_EQ(expected.height, output.height);
}
