plugins {
    `java-library`
}

group = "dev.x341"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    implementation("io.github.cdimascio:java-dotenv:5.2.2")

    implementation("com.google.code.gson:gson:2.13.2")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

val appLibsDir = file("../aonbas-app/libs")

tasks.register<Copy>("buildAndMove") {
    group = "other"

        dependsOn("jar")

    from(layout.buildDirectory.dir("libs")) {
        include("*.jar")
        exclude("*-plain.jar")
    }

    into(appLibsDir)

    duplicatesStrategy = DuplicatesStrategy.INCLUDE

    doFirst {
        println("Initializing build and move")
        if (!appLibsDir.exists()) {
            appLibsDir.mkdirs()
            println("📂Created directory: ${appLibsDir.absolutePath}")
        }
    }

    doLast {
        println("✅ JAR copied successfully to: ${appLibsDir.absolutePath}")
    }
}