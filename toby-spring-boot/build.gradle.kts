dependencies {
    implementation(libs.springboot.web)
    testImplementation(libs.springboot.test)
//    implementation("org.springframework.boot:spring-boot-starter-jetty")

    implementation(libs.springboot.jdbc)
    runtimeOnly(libs.h2)
    implementation("com.zaxxer:HikariCP:6.2.1")

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
