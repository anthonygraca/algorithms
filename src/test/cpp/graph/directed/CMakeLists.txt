add_executable(directed-depth-first-search-test depth-first-search-test.cpp)
target_link_libraries(directed-depth-first-search-test gtest_main directed-depth-first-search)
add_test(NAME directed-depth-first-search-test COMMAND directed-depth-first-search-test)
