plugins {
    id("com.android.library")
    id("kotlin-android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 31
    buildToolsVersion = "30.0.3"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}

dependencies {
    // Dependency Injection
    implementation("com.google.dagger:hilt-android:2.40")
    kapt("com.google.dagger:hilt-android-compiler:2.40")

    // Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0")

    // Modules
    implementation(project(mapOf("path" to ":repository")))
    // remove this
    implementation(project(mapOf("path" to ":network")))
}