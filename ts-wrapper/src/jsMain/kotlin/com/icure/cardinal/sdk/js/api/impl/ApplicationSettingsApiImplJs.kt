// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.ApplicationSettingsApi
import com.icure.cardinal.sdk.js.api.ApplicationSettingsApiJs
import com.icure.cardinal.sdk.js.model.ApplicationSettingsJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.applicationSettings_fromJs
import com.icure.cardinal.sdk.js.model.applicationSettings_toJs
import com.icure.cardinal.sdk.model.ApplicationSettings
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
		val result = applicationSettingsApi.getApplicationSettings(
		)
		listToArray(
			result,
			{ x1: ApplicationSettings ->
				applicationSettings_toJs(x1)
			},
		)
	}

	override fun createApplicationSettings(applicationSettings: ApplicationSettingsJs):
			Promise<ApplicationSettingsJs> = GlobalScope.promise {
		val applicationSettingsConverted: ApplicationSettings =
				applicationSettings_fromJs(applicationSettings)
		val result = applicationSettingsApi.createApplicationSettings(
			applicationSettingsConverted,
		)
		applicationSettings_toJs(result)
	}

	override fun updateApplicationSettings(applicationSettings: ApplicationSettingsJs):
			Promise<ApplicationSettingsJs> = GlobalScope.promise {
		val applicationSettingsConverted: ApplicationSettings =
				applicationSettings_fromJs(applicationSettings)
		val result = applicationSettingsApi.updateApplicationSettings(
			applicationSettingsConverted,
		)
		applicationSettings_toJs(result)
	}
}
