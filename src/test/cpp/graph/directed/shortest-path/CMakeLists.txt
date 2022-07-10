add_executable(directed-weighted-edge-test directed-edge-test.cc)
target_link_libraries(directed-weighted-edge-test gtest_main directed-edge)
add_test(NAME directed-weighted-edge-test COMMAND directed-weighted-edge-test)

add_executable(edge-weighted-digraph-test edge-weighted-digraph-test.cc)
target_link_libraries(edge-weighted-digraph-test
    gtest_main
    edge-weighted-digraph
    directed-edge
)
add_test(NAME edge-weighted-digraph-test COMMAND edge-weighted-digraph-test)

add_executable(dijkstra-test dijkstra-test.cc)
target_link_libraries(dijkstra-test
    gtest_main
    dijkstra
    edge-weighted-digraph
    directed-edge
)
add_test(NAME dijkstra-test COMMAND dijkstra-test)
