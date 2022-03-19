plugins {
    // https://jmfayard.github.io/refreshVersions
    id("de.fayard.refreshVersions") version "0.40.1"
}

refreshVersions {
    enableBuildSrcLibs()
}

rootProject.name = "korden"
include("discord-gateway")
