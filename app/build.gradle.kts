import dependencies.Dependencies
import dependencies.DependencyGroups
import extensions.androidTestImplementation
import extensions.debugImplementation
import extensions.implementation
import extensions.kapt
import extensions.testImplementation

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")
}

android {
    namespace = "com.frhatieh.articlesapp"
    compileSdk = AppConfigConstants.compileSdk

    defaultConfig {
        applicationId = "com.frhatieh.articlesapp"
        minSdk = AppConfigConstants.minSdk
        targetSdk = AppConfigConstants.targetSdk
        versionCode = AppConfigConstants.versionCode
        versionName = AppConfigConstants.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        configurations.all {
            resolutionStrategy {
                force("androidx.emoji2:emoji2-views-helper:1.3.0")
                force("androidx.emoji2:emoji2:1.3.0")
            }
        }

    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
        jvmTarget = AppConfigConstants.JVM_TARGET
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AppConfigConstants.kotlinCompilerExtensionVersion
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(DependencyGroups.androidDependencies)
    implementation(DependencyGroups.composeDependencies)
    testImplementation(DependencyGroups.junitTestImplementationDependencies)
    androidTestImplementation(DependencyGroups.junitAndroidTestImplementationDependencies)
    androidTestImplementation(DependencyGroups.juintComposeUITestDependencies)
    debugImplementation(DependencyGroups.composeUIDebugDependencies)
    implementation(DependencyGroups.navigationDependencies)
    implementation(Dependencies.splashScreen)

    implementation(DependencyGroups.coroutinesDependencies)
    implementation(DependencyGroups.retrofitDependencies)
    implementation(DependencyGroups.loggingInterceptorDependencies)

    implementation(DependencyGroups.glideDependencies)
    annotationProcessor(Dependencies.glideCompiler)

    implementation(DependencyGroups.hiltDependencies)
    kapt(DependencyGroups.hiltKaptDependencies)

    implementation(Dependencies.drawablePainter)
    implementation(Dependencies.accompanistCoil)

    implementation(Dependencies.roomRuntime)
    annotationProcessor(Dependencies.roomCompiler)
    kapt(Dependencies.roomCompilerKapt)
    implementation(Dependencies.roomKtx)
}