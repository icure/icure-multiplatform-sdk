plugins {
    defaultModulePlugins()
}

android {
    configureAndroidLibrary()
}

configureJvmTest()

kotlin {
    configureMultiplatform(this)

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.coroutines)
                implementation(libs.ktorClientCore)
                implementation(libs.ktorContentNegotiation)
                implementation(libs.ktorSerializationJson)
                implementation(libs.kotlinSerialization)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotestAssertions)
                implementation(libs.kotestEngine)
                implementation(libs.kotestDatatest)
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(libs.ktorClientEngineJvm)
                implementation(libs.bouncyCastle)
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(libs.kotestRunnerJunit)
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(libs.ktorClientEngineJs)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.ktorClientEngineAndroid)
                implementation(libs.bouncyCastle)
            }
        }
        val androidUnitTest by getting {
            dependencies {
                implementation(libs.kotestRunnerJunit)
            }
        }
        iosMain {
            dependencies {
                implementation(libs.ktorClientEngineIos)
            }
        }
    }
}
