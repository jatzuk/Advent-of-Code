# Advent of Code with Kotlin repository

Welcome to the Advent of Code puzzles repository!

This repository contains solutions and explanations for various challenges from
the [Advent of Code](https://adventofcode.com) programming competition.

## About Advent of Code

Advent of Code is an annual coding event that takes place in December. Each day, a new programming puzzle is released,
challenging participants to solve problems ranging from simple algorithmic tasks to more complex problems that require
creative thinking. The puzzles cover a variety of programming concepts, making it a great opportunity to enhance your
coding skills.

## Repository Structure

The project is created as a plain Gradle project with a single root module.
You can take a look at a config file in the project root `settings.gradle.kts`.

- **src/main:** Here, you can find solutions to each day's puzzle. Solutions are organized by day number, with
  each solution residing in a separate file named `DayN.kt`, where `N` is the day number.

- **src/test:** The `test` source set contains test cases for each puzzle and stores an input file respectively.

- **src/test/resources:** The `test` source set contains input files for the puzzle.

## Getting Started

1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/jatzuk/aoc.git
    ```

2. Navigate to the cloned directory:

    ```bash
    cd aoc
    ```

3. Sync the Gradle project via IDEA or from the CLI and initialize the wrapper:

    ```gradle
    ./gradlew :wrapper
    ```

4. Explore the challenges and solution files in their respective directories.

## Running Solutions

`Please, pay attention that tests input files are not included in the vcs, so don't forget to grab your own for each day's puzzle`

Each solution file is designed to run independently. Simply use IntelliJ to start tests.

Tests are written using [Kotest](https://kotest.io/docs/quickstart) framework.  

Alternatively, you can use Gradle to run specific tests:

- For example, if you want to examine first puzzle of the day 1, which is in the `D1P1Test.kt` file:

    ```gradle
    ./gradlew :test --tests 'dev.jatzuk.aoc.y2024.day01.D1P1Test' 
    ```
- Or execute all tests within day 2 puzzles (2 parts, each has 2 tests in it):

  ```gradle
  ./gradlew :test --tests 'dev.jatzuk.aoc.y2024.day02.*'
  ```

- Alternatively run all tests under the `test` source set:

    ```gradle
    ./gradlew :test
    ```
