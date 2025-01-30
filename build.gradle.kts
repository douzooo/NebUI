plugins {
    id("java")
}

group = "com.nebulaclient"
version = "1.0-SNAPSHOT"
java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(8))
}
repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")


}

tasks.test {
    useJUnitPlatform()
}