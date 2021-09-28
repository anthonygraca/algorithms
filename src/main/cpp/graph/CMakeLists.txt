add_library(graph OBJECT
            graph.h)

add_subdirectory(undirected)

add_library(digraph OBJECT
            digraph.h)

add_subdirectory(directed)
