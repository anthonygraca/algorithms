cmake_minimum_required(VERSION 3.19.7)

project(Algorithms)

set(source-directory "${CMAKE_SOURCE_DIR}/src")
include_directories(${source-directory})

set(CMAKE_CXX_STANDARD 14)

add_subdirectory(src)

#Turn off with -DTEST=OFF
option(TEST "Build all tests." ON)
if(TEST)
  include(cmake/googletest.cmake)
  add_subdirectory(src/test)
endif()