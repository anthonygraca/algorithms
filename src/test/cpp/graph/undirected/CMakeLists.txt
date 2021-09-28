add_executable(depth-first-search-test depth-first-search-test.cpp)
target_link_libraries(depth-first-search-test gtest_main depth-first-search)
add_test(NAME depth-first-search-test COMMAND depth-first-search-test)

add_executable(depth-first-paths-test depth-first-paths-test.cpp)
target_link_libraries(depth-first-paths-test gtest_main depth-first-paths)
add_test(NAME depth-first-paths-test COMMAND depth-first-paths-test)

add_executable(breadth-first-paths-test breadth-first-paths-test.cpp)
target_link_libraries(breadth-first-paths-test gtest_main breadth-first-paths)
add_test(NAME breadth-first-paths-test COMMAND breadth-first-paths-test)
