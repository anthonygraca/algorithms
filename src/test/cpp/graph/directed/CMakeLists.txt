add_executable(directed-depth-first-search-test depth-first-search-test.cpp)
target_link_libraries(directed-depth-first-search-test gtest_main directed-depth-first-search)
add_test(NAME directed-depth-first-search-test COMMAND directed-depth-first-search-test)

add_executable(directed-cycle-test cycle-test.cpp)
target_link_libraries(directed-cycle-test gtest_main directed-cycle)
add_test(NAME directed-cycle-test COMMAND directed-cycle-test)

add_executable(directed-breadth-first-search-test breadth-first-search-test.cpp)
target_link_libraries(directed-breadth-first-search-test gtest_main directed-breadth-first-search)
add_test(NAME directed-breadth-first-search-test COMMAND directed-breadth-first-search-test)

add_executable(topological-sort-test topological-sort-test.cpp)
target_link_libraries(topological-sort-test gtest_main topological-sort)
add_test(NAME topological-sort-test COMMAND topological-sort-test)

add_executable(kosaraju-sharir-test kosaraju-sharir-test.cpp)
target_link_libraries(kosaraju-sharir-test gtest_main kosaraju-sharir)
add_test(NAME kosaraju-sharir-test COMMAND kosaraju-sharir-test)
