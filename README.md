# Advent of Code Adventures

Welcome to the Advent of Code puzzles repository!

This repository contains solutions and explanations for various challenges from
the [Advent of Code](https://adventofcode.com) programming competition.

## About Advent of Code

Advent of Code is an annual coding event held every December. Each day, a new programming puzzle is released,
challenging participants to solve problems ranging from simple algorithmic tasks to more complex challenges requiring
creative thinking. The puzzles cover a variety of programming concepts, making it an excellent opportunity to enhance
your coding skills.

## Repository Structure

The project is organized as a plain Gradle project with a single root module. You can find the configuration file in the
project root: `settings.gradle.kts`.

- **src/main:** Contains solutions for each day's puzzles. Solutions are organized by day number, with each solution in
  a separate file named `DayN.kt`, where `N` is the day number.
- **src/test:** Contains test cases for each puzzle. Each test corresponds to a specific puzzle and uses the respective
  input file.
- **src/test/resources:** Contains input files used by the test cases. (Not included in vcs, read below)

## Getting Started

1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/jatzuk/aoc.git
    ```

2. Navigate to the cloned directory:

    ```bash
    cd aoc
    ```

3. Sync the Gradle project in IntelliJ IDEA or using the command line, and initialize the wrapper:

    ```gradle
    ./gradlew :wrapper
    ```

4. Explore the challenges and solution files in their respective directories.

## Running Solutions

**Note:**
Test input files are not included in version control, so make sure to download your own inputs for each day's puzzles.

Each solution file can be run independently. Use IntelliJ IDEA to start the corresponding tests.

Tests are written using the [Kotest](https://kotest.io/docs/quickstart) framework.

Alternatively, you can run tests using Gradle:

- To run the test for the first puzzle of day 1 (`D1P1Test.kt`):

    ```gradle
    ./gradlew :test --tests 'dev.jatzuk.aoc.y2024.day01.D1P1Test'
    ```

- To run all tests for day 2 puzzles (both parts):

    ```gradle
    ./gradlew :test --tests 'dev.jatzuk.aoc.y2024.day02.*'
    ```

- To run all tests in the `test` source set:

    ```gradle
    ./gradlew :test
    ```
