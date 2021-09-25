add_executable(depth-first-search-test depth-first-search-test.cpp)
target_link_libraries(depth-first-search-test gtest_main depth-first-search)
add_test(NAME depth-first-search-test COMMAND depth-first-search-test)
