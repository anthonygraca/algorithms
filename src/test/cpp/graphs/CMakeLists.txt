add_executable(graph-test graph-test.cpp)
target_link_libraries(graph-test gtest_main graph)
add_test(NAME graph-test COMMAND graph-test)

add_subdirectory(undirected)
