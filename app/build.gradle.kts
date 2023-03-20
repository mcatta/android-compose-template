@file:Suppress("UnstableApiUsage")

/*
* Copyright 2021 Marco Cattaneo
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.android.hilt)
    alias(libs.plugins.kotlin.android)
    kotlin("kapt")
}

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "dev.marcocattaneo.androidcomposetemplate"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFile(getDefaultProguardFile("proguard-android-optimize.txt"))
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    val platform = platform(libs.bom.compose)
    implementation(platform)
    androidTestImplementation(platform)

    implementation(libs.androidx.core)
    implementation(libs.androidx.material)

    implementation(libs.compose.ui)
    implementation(libs.compose.material)
    implementation(libs.compose.preview)
    implementation(libs.compose.navigation.core)
    implementation(libs.compose.navigation.hilt)
    implementation(libs.compose.activity)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.compose.test.uiJunit4)

    implementation(libs.hilt.android)
    kapt(libs.hilt.androidCompiler)

    debugImplementation(libs.compose.test.uiManifest)
    debugImplementation(libs.compose.tooling)
    debugImplementation(libs.compose.preview)
}