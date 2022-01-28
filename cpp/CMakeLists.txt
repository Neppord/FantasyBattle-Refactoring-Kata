cmake_minimum_required(VERSION 3.16)
project(FantasyBattle)

enable_testing()

include(FetchContent)
FetchContent_Declare(googletest
        GIT_REPOSITORY https://github.com/google/googletest.git
        GIT_TAG        release-1.10.0
        GIT_SHALLOW    1
)
FetchContent_MakeAvailable(googletest)
include(GoogleTest)

set(CMAKE_CXX_STANDARD 11)

add_executable(FantasyBattle test/main.cpp
        model/Damage.cpp model/Damage.h
        model/Inventory.cpp model/Inventory.h
        model/Player.cpp model/Player.h
        test/PlayerTest.cpp
        model/Stats.cpp model/Stats.h
        model/Equipment.cpp model/Equipment.h
        model/SimpleArmor.cpp model/SimpleArmor.h model/Armor.h
        model/BasicBuff.cpp model/BasicBuff.h model/Buff.h
        model/SimpleEnemy.cpp model/SimpleEnemy.h
        model/Target.h
        model/BasicItem.cpp model/BasicItem.h model/Item.h)
target_link_libraries(FantasyBattle gtest ${CMAKE_THREAD_LIBS_INIT})
gtest_discover_tests(FantasyBattle)
