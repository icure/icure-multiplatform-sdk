package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.FailedRequestDetails
import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun failedRequestDetails_toJs(obj: FailedRequestDetails): FailedRequestDetailsJs {
	val entityId = obj.entityId
	val delegateId = obj.delegateId
	val updatedForMigration = obj.updatedForMigration
	val code = nullToUndefined(
		intToNumber(obj.code)
	)
	val reason = nullToUndefined(
		obj.reason
	)
	val request = nullToUndefined(
		obj.request?.let { nonNull1 ->
			delegateShareOptions_toJs(nonNull1)
		}
	)
	return FailedRequestDetailsJs(js("{" +
		"entityId:entityId," +
		"delegateId:delegateId," +
		"updatedForMigration:updatedForMigration," +
		"code:code," +
		"reason:reason," +
		"request:request" +
	"}"))
}

public fun failedRequestDetails_fromJs(obj: FailedRequestDetailsJs): FailedRequestDetails {
	val entityId = obj.entityId
	val delegateId = obj.delegateId
	val updatedForMigration = obj.updatedForMigration
	val code = numberToInt(obj.code, "obj.code")
	val reason = undefinedToNull(obj.reason)
	val request = obj.request?.let { nonNull1 ->
		delegateShareOptions_fromJs(nonNull1)
	}
	return FailedRequestDetails(
		entityId = entityId,
		delegateId = delegateId,
		updatedForMigration = updatedForMigration,
		code = code,
		reason = reason,
		request = request,
	)
}
