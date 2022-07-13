cmake_minimum_required(VERSION 3.22)

project(Algorithms
        LANGUAGES CXX)

set(CMAKE_BUILD_TYPE Debug)

set(source-directory
  "${CMAKE_SOURCE_DIR}"
  "${CMAKE_SOURCE_DIR}/src/main/cpp/")
include_directories(${source-directory})

set(CMAKE_CXX_STANDARD 20)
add_compile_options(-fsanitize=address)
add_link_options(-fsanitize=address)

add_subdirectory(src)

# Turn off with -DTEST=OFF
option(TEST "Build all tests." ON)

include(FetchContent)
FetchContent_Declare(
  googletest
  URL https://github.com/google/googletest/archive/e649993a402d96afe25fbf3413749adf0f2947f6.zip
)
FetchContent_MakeAvailable(googletest)

if(TEST)
  enable_testing()
  add_subdirectory(src/test)
endif()
