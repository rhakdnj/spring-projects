dependencies {
    implementation(libs.springboot.web)
    testImplementation(libs.springboot.starter.test)

    implementation("org.springframework:spring-jdbc")
    runtimeOnly("com.h2database:h2")
    implementation("com.zaxxer:HikariCP:6.2.1")

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
