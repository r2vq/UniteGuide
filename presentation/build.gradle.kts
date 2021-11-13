plugins {
    id("com.android.library")
    id("kotlin-android")
    id("androidx.navigation.safeargs.kotlin")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
}

android {
    compileSdk = 31
    buildToolsVersion = "30.0.3"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.1"
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}

dependencies {
    // Dependency Injection
    implementation("com.google.dagger:hilt-android:2.40.1")
    kapt("com.google.dagger:hilt-android-compiler:2.40.1")

    // Compose
    implementation("androidx.compose.material:material:1.0.5")
    implementation("androidx.compose.ui:ui-tooling:1.0.5")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0")
    implementation("androidx.navigation:navigation-compose:2.4.0-beta02")
    implementation("io.coil-kt:coil-compose:1.4.0")

    // Modules
    implementation(project(mapOf("path" to ":domain")))
}