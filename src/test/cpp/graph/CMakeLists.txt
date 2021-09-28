add_executable(graph-test graph-test.cpp)
target_link_libraries(graph-test gtest_main graph)
add_test(NAME graph-test COMMAND graph-test)

add_subdirectory(undirected)

add_executable(digraph-test digraph-test.cpp)
target_link_libraries(digraph-test gtest_main digraph)
add_test(NAME digraph-test COMMAND digraph-test)

add_subdirectory(directed)
