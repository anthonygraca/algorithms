add_executable(edge-weighted-graph-test edge-weighted-graph-test.cc)
target_link_libraries(edge-weighted-graph-test gtest_main edge-weighted-graph)
add_test(NAME edge-weighted-graph-test COMMAND edge-weighted-graph-test)
