@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotestMultiplatform) apply false
    alias(libs.plugins.kotlinSerialization) apply false
}

group = "com.icure"
version = "0.0.1"
