plugins {
  kotlin("jvm") version "2.0.20"
}

group = "dev.jatzuk"
version = "1.0"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation("io.kotest:kotest-runner-junit5-jvm:5.9.1")
}

tasks.test {
  useJUnitPlatform()

  filter {
    includeTestsMatching("dev.jatzuk.aoc.y2024.*")
  }
}

kotlin {
  jvmToolchain(21)
}
