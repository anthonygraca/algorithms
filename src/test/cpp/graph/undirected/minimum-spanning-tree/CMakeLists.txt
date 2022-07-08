add_executable(edge-weighted-graph-test edge-weighted-graph-test.cc)
target_link_libraries(edge-weighted-graph-test gtest_main edge-weighted-graph)
add_test(NAME edge-weighted-graph-test COMMAND edge-weighted-graph-test)

add_executable(lazy-prim-mst-test lazy-prim-test.cc)
target_link_libraries(lazy-prim-mst-test gtest_main lazy-prim-mst)
add_test(NAME lazy-prim-mst-test COMMAND lazy-prim-mst-test)

add_executable(eager-prim-mst-test eager-prim-test.cc)
target_link_libraries(eager-prim-mst-test gtest_main eager-prim-mst)
add_test(NAME eager-prim-mst-test COMMAND eager-prim-mst-test)
