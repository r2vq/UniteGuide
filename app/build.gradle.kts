plugins {
    id("com.android.application")
    id("kotlin-android")
    id("androidx.navigation.safeargs.kotlin")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 31
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "ca.keaneq.uniteguide"
        minSdk = 30
        targetSdk = 30
        versionCode = 2
        versionName = "2.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.1"
    }
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}

dependencies {
    // Android Core
    implementation("com.google.android.material:material:1.4.0")

    // Compose
    implementation("androidx.activity:activity-compose:1.4.0")

    // Dependency Injection
    implementation("com.google.dagger:hilt-android:2.40.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")
    kapt("com.google.dagger:hilt-android-compiler:2.40.1")

    // Modules
    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":network")))
    implementation(project(mapOf("path" to ":presentation")))
    implementation(project(mapOf("path" to ":repository")))
    implementation(project(mapOf("path" to ":preferences")))

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.1.0-beta02")
}