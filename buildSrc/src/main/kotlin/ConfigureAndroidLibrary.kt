import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion

@Suppress("UnstableApiUsage")
fun LibraryExtension.configureAndroidLibrary() {
    namespace = "com.icure.sdk"
    compileSdk = 34
    sourceSets.getByName("main").manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 26
        targetSdk = 34
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    testOptions {
        unitTests.all {
            it.useJUnitPlatform()
        }
    }
    lint {
        checkReleaseBuilds = false
        abortOnError = false
    }
}