plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = Config.NAMESPACE
    compileSdk = Config.COMPILE_SDK

    defaultConfig {
        applicationId = Config.APPLICATION_ID
        minSdk = Config.MIN_SDK
        targetSdk = Config.TARGET_SDK
        versionCode = Config.VERSION_CODE
        versionName = Config.VERSION_NAME

        testInstrumentationRunner = Config. TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(Config.PROGUARD_ANDROID_OPTIMIZE_FILE_NAME),
                Config.PROGUARD_RULES_PRO_FILE_NAME
            )
        }
    }
    compileOptions {
        sourceCompatibility = Config.javaVersion
        targetCompatibility = Config.javaVersion
    }
    kotlinOptions {
        jvmTarget = Config.javaVersion.toString()
    }
    sourceSets["main"].java.srcDirs(Config.SOURCE_MAIN_DIRECTORY)
    sourceSets["test"].java.srcDirs(Config.SOURCE_TEST_DIRECTORY)
    sourceSets["androidTest"].java.srcDirs(Config.SOURCE_ANDROID_TEST_DIRECTORY)
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}