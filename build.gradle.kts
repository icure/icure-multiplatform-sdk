@Suppress("DSL_SCOPE_VIOLATION")
plugins {
	kotlinMultiplatform(false)
	kotlinSerialization(false)
	kotestMultiplatform(false)
	androidLibrary(false)
}

allprojects {
	group = "com.icure"
}
version = "0.0.1"
