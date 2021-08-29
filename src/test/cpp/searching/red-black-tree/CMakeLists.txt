add_executable(red-black-tree-test red-black-tree-test.cpp)
target_link_libraries(red-black-tree-test gtest_main red-black-tree)
add_test(NAME red-black-tree-test COMMAND red-black-tree-test)
