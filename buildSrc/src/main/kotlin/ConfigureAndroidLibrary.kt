import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion

@Suppress("UnstableApiUsage")
fun LibraryExtension.configureAndroidLibrary() {
	compileSdk = 34
	sourceSets.getByName("main").manifest.srcFile("src/androidMain/AndroidManifest.xml")
	defaultConfig {
		minSdk = 26
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	testOptions {
		targetSdk = 34
		unitTests.all {
			it.useJUnitPlatform()
		}
	}
	lint {
		checkReleaseBuilds = false
		abortOnError = false
	}
}