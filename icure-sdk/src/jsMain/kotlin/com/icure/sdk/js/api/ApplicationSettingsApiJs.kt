// auto-generated file
package com.icure.sdk.js.api

import com.icure.sdk.js.model.ApplicationSettingsJs
import kotlin.Array
import kotlin.js.JsName
import kotlin.js.Promise

@JsName("ApplicationSettingsApi")
public external interface ApplicationSettingsApiJs {
	public fun getApplicationSettings(): Promise<Array<ApplicationSettingsJs>>

	public fun createApplicationSettings(applicationSettings: ApplicationSettingsJs):
			Promise<ApplicationSettingsJs>

	public fun updateApplicationSettings(applicationSettings: ApplicationSettingsJs):
			Promise<ApplicationSettingsJs>
}
