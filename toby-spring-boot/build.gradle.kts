dependencies {
    implementation(libs.springboot.web)
    testImplementation(libs.springboot.starter.test)
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
