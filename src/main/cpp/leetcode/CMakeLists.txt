# Arrays & Hashing
add_library(217-contains-duplicate OBJECT 217-contains-duplicate.h)

add_library(242-valid-anagram OBJECT 242-valid-anagram.h)

add_library(1-two-sum OBJECT 1-two-sum.h)

add_library(49-group-anagrams OBJECT 49-group-anagrams.h)

# Graphs
add_library(200-number-of-islands OBJECT 200-number-of-islands.h)

add_library(133-clone-graph OBJECT 133-clone-graph.h)
target_link_libraries(133-clone-graph PUBLIC node)

add_library(node OBJECT node.h)

add_library(695-max-area-of-island OBJECT 695-max-area-of-island.h)

add_library(417-pacific-atlantic-water-flow OBJECT 417-pacific-atlantic-water-flow.h)

add_library(130-surrounded-regions OBJECT 130-surrounded-regions.h)

add_library(997-rotting-oranges OBJECT 997-rotting-oranges.h)

add_library(207-course-schedule-1 OBJECT 207-course-schedule-1.h)

add_library(210-course-schedule-2 OBJECT 210-course-schedule-2.h)

add_library(684-redundant-connection OBJECT 684-redundant-connection.h)

