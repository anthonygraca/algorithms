add_executable(merge-sort-test merge-sort-test.cpp)
target_link_libraries(merge-sort-test gtest_main merge-sort)
add_test(NAME merge-sort-test COMMAND merge-sort-test)

add_executable(merge-sort-bottom-up-test merge-sort-bottom-up-test.cpp)
target_link_libraries(merge-sort-bottom-up-test gtest_main merge-sort-bottom-up)
add_test(NAME merge-sort-bottom-up-test COMMAND merge-sort-bottom-up-test)
