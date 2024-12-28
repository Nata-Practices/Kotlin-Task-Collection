plugins {
    id("java")
}

group = "ru.homework"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.register("buildFirstTask", type = Jar::class)  {
    group = "custom"
    val mainClass = "ru.homework.MainTask1"
    val jarFileName = "Task1"
    archiveBaseName.set(jarFileName.substringBeforeLast('.'))
    from(sourceSets.main.get().output)
    manifest {
        attributes["Main-Class"] = mainClass
    }
}

tasks.register("buildSecondTask", type = Jar::class) {
    group = "custom"
    val mainClass = "ru.homework.MainTask2"
    val jarFileName = "Task2"
    archiveBaseName.set(jarFileName.substringBeforeLast('.'))
    from(sourceSets.main.get().output)
    manifest {
        attributes["Main-Class"] = mainClass
    }
}

tasks.register("buildThirdTask", type = Jar::class) {
    group = "custom"
    val mainClass = "ru.homework.MainTask3"
    val jarFileName = "Task3"
    archiveBaseName.set(jarFileName.substringBeforeLast('.'))
    from(sourceSets.main.get().output)
    manifest {
        attributes["Main-Class"] = mainClass
    }
}

tasks.register("buildFourthTask", type = Jar::class) {
    group = "custom"
    val mainClass = "ru.homework.MainTask4"
    val jarFileName = "Task4"
    archiveBaseName.set(jarFileName.substringBeforeLast('.'))
    from(sourceSets.main.get().output)
    manifest {
        attributes["Main-Class"] = mainClass
    }
}
