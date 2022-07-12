add_library(200-number-of-islands OBJECT 200-number-of-islands.h)

add_library(133-clone-graph OBJECT 133-clone-graph.h)
target_link_libraries(133-clone-graph PUBLIC node)

add_library(node OBJECT node.h)

add_library(695-max-area-of-island OBJECT 695-max-area-of-island.h)
