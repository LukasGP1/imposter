plugins {
    id("java")
    id("application")
}

group = "de.lulkas_"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {

}

application {
    mainClass.set("de.lulkas_.Main")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "de.lulkas_.Main"
    }

    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath.get())
    from({
        configurations.runtimeClasspath.get()
            .filter { it.name.endsWith("jar") }
            .map { zipTree(it) }
    })
}