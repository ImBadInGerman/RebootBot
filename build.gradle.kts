plugins {
    id("java")
    id("application")
    id("com.gradleup.shadow") version "8.3.1"
}

application {
    mainClass = "de.imbadingerman.reboot.Main"
}

group = "de.imbadingerman.reboot"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("net.dv8tion:JDA:5.3.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.isIncremental = true

    // Set this to the version of java you want to use,
    // the minimum required for JDA is 1.8
    sourceCompatibility = "1.8"
    targetCompatibility = "1.8"
}