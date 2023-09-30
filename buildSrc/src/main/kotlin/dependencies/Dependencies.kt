package dependencies

object Dependencies {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${DependencyVersions.kotlin_version}"

    const val core = "androidx.core:core-ktx:${DependencyVersions.core_version}"
    const val appcompat = "androidx.appcompat:appcompat:${DependencyVersions.appcompat_version}"
    const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${DependencyVersions.lifecycle_version}"
    const val viewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${DependencyVersions.lifecycle_version}"

    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${DependencyVersions.coroutines_version}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${DependencyVersions.coroutines_version}"

    const val composeActicity = "androidx.activity:activity-compose:${DependencyVersions.compose_activity_version}"
    const val composeViewmodel =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${DependencyVersions.lifecycle_version}"
    const val composeLifecycle =
        "androidx.lifecycle:lifecycle-runtime-compose:${DependencyVersions.lifecycle_version}"
    const val composeMaterial3 =
        "androidx.compose.material3:material3:${DependencyVersions.compose_material3_version}"
    const val composeAnimation =
        "androidx.compose.animation:animation:${DependencyVersions.compose_version}"
    const val composeFoundation =
        "androidx.compose.foundation:foundation:${DependencyVersions.compose_version}"
    const val composeCompiler =
        "androidx.compose.compiler:compiler:${DependencyVersions.compose_compiler_version}"
    const val composeRuntime =
        "androidx.compose.runtime:runtime:${DependencyVersions.compose_version}"
    const val composeUi = "androidx.compose.ui:ui:${DependencyVersions.compose_version}"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics:${DependencyVersions.compose_version}"
    const val composeUiPreview =
        "androidx.compose.ui:ui-tooling-preview:${DependencyVersions.compose_version}"
    const val composeTracingPreview =
        "androidx.compose.runtime:runtime-tracing:${DependencyVersions.compose_tracing_version}"
    const val composeUITooling =
        "androidx.compose.ui:ui-tooling:${DependencyVersions.compose_version}"
    const val composeUITestManifest = "androidx.compose.ui:ui-test-manifest:${DependencyVersions.compose_version}"
    const val constraintlayoutCompose = "androidx.constraintlayout:constraintlayout-compose:${DependencyVersions.constraintlayout_compose_version}"

    const val junitComposeUITest = "androidx.compose.ui:ui-test-junit4:${DependencyVersions.compose_version}"

    const val junitTestImplementation =
        "junit:junit:${DependencyVersions.junitTestImplementation_version}"
    const val junitExtAndroidTestImplementation =
        "androidx.test.ext:junit:${DependencyVersions.junitExtAndroidTestImplementation_version}"
    const val espressoAndroidTestImplementation =
        "androidx.test.espresso:espresso-core:${DependencyVersions.espressoAndroidTestImplementation_version}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${DependencyVersions.hilt_version}"
    const val hiltCompilerKapt =
        "com.google.dagger:hilt-android-compiler:${DependencyVersions.hilt_version}"
    const val hiltViewModel = "androidx.hilt:hilt-navigation-compose:${DependencyVersions.hilt_compose_version}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${DependencyVersions.retrofit_version}"
    const val gson = "com.google.code.gson:gson:${DependencyVersions.gson_version}"
    const val converterGson =
        "com.squareup.retrofit2:converter-gson:${DependencyVersions.retrofit_version}"

    const val glide = "com.github.bumptech.glide:glide:${DependencyVersions.glide_version}"
    const val glideCompiler =
        "com.github.bumptech.glide:compiler:${DependencyVersions.glide_version}"
    const val glideTransformations =
        "jp.wasabeef:glide-transformations:${DependencyVersions.glide_transformations}"

    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${DependencyVersions.loggingInterceptor_version}"

    const val navigationCompose = "androidx.navigation:navigation-compose:${DependencyVersions.navigation_version}"

    const val drawablePainter = "com.google.accompanist:accompanist-drawablepainter:${DependencyVersions.drawablePainter_version}"

    const val accompanistCoil = "com.google.accompanist:accompanist-coil:${DependencyVersions.accompanistCoil_version}"

    const val splashScreen = "androidx.core:core-splashscreen:${DependencyVersions.splashScreen_version}"

    const val roomRuntime = "androidx.room:room-runtime:${DependencyVersions.room_version}"
    const val roomCompiler = "androidx.room:room-compiler:${DependencyVersions.room_version}"
    const val roomCompilerKapt = "androidx.room:room-compiler:${DependencyVersions.room_version}"
    const val roomKtx = "androidx.room:room-ktx:${DependencyVersions.room_version}"

    const val firebaseAuthKtx = "com.google.firebase:firebase-auth-ktx:${DependencyVersions.firebase_auth_ktx}"
    const val firebaseDatabase = "com.google.firebase:firebase-database-ktx:${DependencyVersions.firebase_database}"
    const val material = "androidx.compose.material:material:${DependencyVersions.material_version}"
    val accompanistVersion = "0.13.0"
    const val swipeRefresh = "com.google.accompanist:accompanist-swiperefresh:${DependencyVersions.accompanistCoil_version}"
}