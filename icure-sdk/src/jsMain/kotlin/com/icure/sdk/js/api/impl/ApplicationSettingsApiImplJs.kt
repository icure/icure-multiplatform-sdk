// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.ApplicationSettingsApi
import com.icure.sdk.js.api.ApplicationSettingsApiJs
import com.icure.sdk.js.model.ApplicationSettingsJs
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.applicationSettings_toJs
import com.icure.sdk.model.ApplicationSettings
import kotlin.Array
import kotlin.OptIn
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class ApplicationSettingsApiImplJs(
	private val applicationSettingsApi: ApplicationSettingsApi,
) : ApplicationSettingsApiJs {
	override fun getApplicationSettings(): Promise<Array<ApplicationSettingsJs>> =
			GlobalScope.promise {
		listToArray(
			applicationSettingsApi.getApplicationSettings(),
			{ x1: ApplicationSettings ->
				applicationSettings_toJs(x1)
			},
		)}


	override fun createApplicationSettings(applicationSettings: ApplicationSettingsJs):
			Promise<ApplicationSettingsJs> = GlobalScope.promise {
		applicationSettings_toJs(applicationSettingsApi.createApplicationSettings(com.icure.sdk.js.model.applicationSettings_fromJs(applicationSettings)))}


	override fun updateApplicationSettings(applicationSettings: ApplicationSettingsJs):
			Promise<ApplicationSettingsJs> = GlobalScope.promise {
		applicationSettings_toJs(applicationSettingsApi.updateApplicationSettings(com.icure.sdk.js.model.applicationSettings_fromJs(applicationSettings)))}

}
