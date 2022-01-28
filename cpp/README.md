Installation Instructions
=========================

To compile and run your tests, you you will need:

- make, cmake and a C++ compiler (like gcc) is installed on your system and is in the PATH

More Verbose Instructions
-------------------------

Make the FantasyBattle-Refactoring-Kata:

    mkdir build
    cd build
    cmake -G "Unix Makefiles" ..
    cmake --build .

Then you should be able to run the tests:

    ctest

or

    ./FantasyBattle

If you have been successful, then you should see a failing test, DamageCalculations.
