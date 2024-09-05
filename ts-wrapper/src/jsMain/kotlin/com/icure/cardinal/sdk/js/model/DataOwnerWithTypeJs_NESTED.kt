// auto-generated file
@file:JsQualifier("model.DataOwnerWithType")

package com.icure.cardinal.sdk.js.model

import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("HcpDataOwner")
public external class DataOwnerWithTypeJs_HcpDataOwnerJs(
	partial: dynamic,
) : DataOwnerWithTypeJs {
	override val dataOwner: HealthcarePartyJs

	override val ktClass: String
}

@JsName("PatientDataOwner")
public external class DataOwnerWithTypeJs_PatientDataOwnerJs(
	partial: dynamic,
) : DataOwnerWithTypeJs {
	override val dataOwner: EncryptedPatientJs

	override val ktClass: String
}

@JsName("DeviceDataOwner")
public external class DataOwnerWithTypeJs_DeviceDataOwnerJs(
	partial: dynamic,
) : DataOwnerWithTypeJs {
	override val dataOwner: DeviceJs

	override val ktClass: String
}
