import com.github.jk1.license.render.CsvReportRenderer
import com.github.jk1.license.render.ReportRenderer

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
	kotlinMultiplatform(false)
	kotlinSerialization(false)
	kotestMultiplatform(false)
	androidLibrary(false)
	licenseReportPlugin(true)
	id("com.vanniktech.maven.publish") version "0.30.0" apply false
}

licenseReport {
	renderers = arrayOf<ReportRenderer>(CsvReportRenderer())
}

allprojects {
	group = "com.icure"
}
version = "0.0.1"
