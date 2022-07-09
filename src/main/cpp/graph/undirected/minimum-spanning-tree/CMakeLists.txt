add_library(edge-weighted-graph OBJECT edge.h edge-weighted-graph.h)

add_library(lazy-prim-mst OBJECT lazy-prim.h)
target_link_libraries(lazy-prim-mst edge-weighted-graph)

add_library(kruskal-mst OBJECT kruskal-mst.h)
target_link_libraries(kruskal-mst edge-weighted-graph)
