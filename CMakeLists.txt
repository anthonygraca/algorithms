cmake_minimum_required(VERSION 3.22)

project(Algorithms
        LANGUAGES CXX)

set(CMAKE_BUILD_TYPE Debug)

set(source-directory
  "${CMAKE_SOURCE_DIR}"
  "${CMAKE_SOURCE_DIR}/src/main/cpp/")
include_directories(${source-directory})

set(CMAKE_CXX_STANDARD 20)
if(0)
add_compile_options(
    -Wfatal-errors
    -Werror
    -Walloca
    -Wcast-qual
    -Wconversion
    -Wformat=2
    -Wformat-security
    -Wnull-dereference
    -Wstack-protector
    -Wvla
    -Warray-bounds
    -Warray-bounds-pointer-arithmetic
    -Wassign-enum
    -Wbad-function-cast
    -Wconditional-uninitialized
    -Wconversion
    -Wfloat-equal
    -Wformat-type-confusion
    -Widiomatic-parentheses
    -Wimplicit-fallthrough
    -Wloop-analysis
    -Wpointer-arith
    -Wshift-sign-overflow
    -Wshorten-64-to-32
    -Wtautological-constant-in-range-compare
    -Wunreachable-code-aggressive -Wthread-safety
    -Wthread-safety-beta
    -U_FORTIFY_SOURCE
    -D_FORTIFY_SOURCE=2
    -fstack-protector-strong
    -fPIE
    -fsanitize=address
    -fno-omit-frame-pointer
    -fsanitize=undefined
    -fsanitize=float-divide-by-zero
    -fsanitize=float-cast-overflow
    -fsanitize=integer
)
add_link_options(-fsanitize=address
    -fno-omit-frame-pointer
    -fsanitize=undefined
    -fsanitize=float-divide-by-zero
    -fsanitize=float-cast-overflow
    -fsanitize=integer
)
endif()

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
