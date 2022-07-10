add_library(directed-edge OBJECT directed-edge.h)

add_library(edge-weighted-digraph OBJECT edge-weighted-digraph.h)
target_link_libraries(edge-weighted-digraph PUBLIC directed-edge)

add_library(dijkstra OBJECT dijkstra.h)
target_link_libraries(dijkstra PUBLIC edge-weighted-digraph directed-edge)
