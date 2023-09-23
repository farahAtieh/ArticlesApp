package dependencies

object DependencyGroups {
    val androidDependencies = arrayListOf<String>().apply {
        add(Dependencies.core)
        add(Dependencies.lifecycleRuntime)
    }

    val composeDependencies = arrayListOf<String>().apply {
        add(Dependencies.composeActicity)
        add(Dependencies.composeUi)
        add(Dependencies.composeUiGraphics)
        add(Dependencies.composeUiPreview)
        add(Dependencies.composeMaterial3)
        add(Dependencies.constraintlayoutCompose)
        add(Dependencies.composeTracingPreview)
        add(Dependencies.composeLifecycle)
    }

    val junitTestImplementationDependencies = arrayListOf<String>().apply {
        add(Dependencies.junitTestImplementation)
    }

    val junitAndroidTestImplementationDependencies = arrayListOf<String>().apply {
        add(Dependencies.junitExtAndroidTestImplementation)
        add(Dependencies.espressoAndroidTestImplementation)
    }

    val juintComposeUITestDependencies = arrayListOf<String>().apply {
        add(Dependencies.junitComposeUITest)
    }

    val composeUIDebugDependencies = arrayListOf<String>().apply {
        add(Dependencies.composeUITooling)
        add(Dependencies.composeUITestManifest)
    }

    val coroutinesDependencies = arrayListOf<String>().apply {
        add(Dependencies.coroutinesCore)
        add(Dependencies.coroutinesAndroid)
    }

    val hiltDependencies = arrayListOf<String>().apply {
        add(Dependencies.hiltAndroid)
        add(Dependencies.hiltViewModel)
    }

    val hiltKaptDependencies = arrayListOf<String>().apply {
        add(Dependencies.hiltCompilerKapt)
    }

    val retrofitDependencies = arrayListOf<String>().apply {
        add(Dependencies.retrofit)
        add(Dependencies.gson)
        add(Dependencies.converterGson)
    }

    val glideDependencies = arrayListOf<String>().apply {
        add(Dependencies.glide)
        add(Dependencies.glideTransformations)
    }


    val loggingInterceptorDependencies = arrayListOf<String>().apply {
        add(Dependencies.loggingInterceptor)
    }

    val navigationDependencies = arrayListOf<String>().apply {
        add(Dependencies.navigationCompose)
    }

}