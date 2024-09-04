// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.ApplicationSettingsJs
import kotlin.Array
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ApplicationSettingsApi")
public external interface ApplicationSettingsApiJs {
	public fun getApplicationSettings(): Promise<Array<ApplicationSettingsJs>>

	public fun createApplicationSettings(applicationSettings: ApplicationSettingsJs):
			Promise<ApplicationSettingsJs>

	public fun updateApplicationSettings(applicationSettings: ApplicationSettingsJs):
			Promise<ApplicationSettingsJs>
}
