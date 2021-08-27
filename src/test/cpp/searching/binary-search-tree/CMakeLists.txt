add_executable(binary-search-tree-test binary-search-tree-test.cpp)
target_link_libraries(binary-search-tree-test gtest_main binary-search-tree)
add_test(NAME binary-search-tree-test COMMAND binary-search-tree-test)
