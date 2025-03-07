import org.gradle.api.JavaVersion

object Config {
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0.1"

    const val NAMESPACE = "br.com.denismagno.android.sleeptoken"

    const val COMPILE_SDK = 35
    const val MIN_SDK = 24
    const val TARGET_SDK = 35

    const val APPLICATION_ID = NAMESPACE

    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"

    const val PROGUARD_ANDROID_OPTIMIZE_FILE_NAME = "proguard-android-optimize.txt"
    const val PROGUARD_RULES_PRO_FILE_NAME = "proguard-rules.pro"

    const val SOURCE_MAIN_DIRECTORY = "src/main/java"
    const val SOURCE_TEST_DIRECTORY = "src/test/java"
    const val SOURCE_ANDROID_TEST_DIRECTORY = "src/androidTest/java"

    val javaVersion = JavaVersion.VERSION_11
}