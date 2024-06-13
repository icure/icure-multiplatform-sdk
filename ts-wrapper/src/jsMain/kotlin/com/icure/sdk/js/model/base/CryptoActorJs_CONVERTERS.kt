package com.icure.sdk.js.model.base

import com.icure.sdk.js.model.CryptoActorStubJs
import com.icure.sdk.js.model.DecryptedPatientJs
import com.icure.sdk.js.model.DeviceJs
import com.icure.sdk.js.model.EncryptedPatientJs
import com.icure.sdk.js.model.HealthcarePartyJs
import com.icure.sdk.js.model.cryptoActorStub_fromJs
import com.icure.sdk.js.model.cryptoActorStub_toJs
import com.icure.sdk.js.model.device_fromJs
import com.icure.sdk.js.model.device_toJs
import com.icure.sdk.js.model.healthcareParty_fromJs
import com.icure.sdk.js.model.healthcareParty_toJs
import com.icure.sdk.js.model.patient_fromJs
import com.icure.sdk.js.model.patient_toJs
import com.icure.sdk.model.CryptoActorStub
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.Device
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.base.CryptoActor
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun cryptoActor_toJs(obj: CryptoActor): CryptoActorJs = when (obj) {
	is CryptoActorStub -> cryptoActorStub_toJs(obj)
	is EncryptedPatient -> patient_toJs(obj)
	is DecryptedPatient -> patient_toJs(obj)
	is Device -> device_toJs(obj)
	is HealthcareParty -> healthcareParty_toJs(obj)
	else -> throw
			IllegalArgumentException("""Unknown concrete implementation for com.icure.sdk.model.base.CryptoActor: $obj""")
}

public fun cryptoActor_fromJs(obj: CryptoActorJs): CryptoActor = when {
	obj is CryptoActorStubJs || obj.ktClass ==
			"com.icure.sdk.model.CryptoActorStub" ->cryptoActorStub_fromJs(obj as
			com.icure.sdk.js.model.CryptoActorStubJs)
	obj is EncryptedPatientJs || obj.ktClass ==
			"com.icure.sdk.model.EncryptedPatient" ->patient_fromJs(obj as
			com.icure.sdk.js.model.EncryptedPatientJs)
	obj is DecryptedPatientJs || obj.ktClass ==
			"com.icure.sdk.model.DecryptedPatient" ->patient_fromJs(obj as
			com.icure.sdk.js.model.DecryptedPatientJs)
	obj is DeviceJs || obj.ktClass == "com.icure.sdk.model.Device" ->device_fromJs(obj as
			com.icure.sdk.js.model.DeviceJs)
	obj is HealthcarePartyJs || obj.ktClass ==
			"com.icure.sdk.model.HealthcareParty" ->healthcareParty_fromJs(obj as
			com.icure.sdk.js.model.HealthcarePartyJs)
	else -> throw
			IllegalArgumentException("""Unknown concrete implementation for com.icure.sdk.model.base.CryptoActor: $obj""")
}
