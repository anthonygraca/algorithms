add_library(number-of-islands OBJECT 200-number-of-islands.h)

add_library(clone-graph OBJECT 133-clone-graph.h)
target_link_libraries(clone-graph PUBLIC node)

add_library(node OBJECT node.h)
