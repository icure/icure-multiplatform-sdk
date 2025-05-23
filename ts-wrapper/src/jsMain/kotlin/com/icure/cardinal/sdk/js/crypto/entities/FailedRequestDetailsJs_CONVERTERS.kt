// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.FailedRequestDetails
import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun failedRequestDetails_toJs(obj: FailedRequestDetails): FailedRequestDetailsJs {
	val entityId = obj.entityId
	val delegateReference = entityReferenceInGroup_toJs(obj.delegateReference)
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
	val shouldRetry = obj.shouldRetry
	return FailedRequestDetailsJs(js("{" +
		"entityId:entityId," +
		"delegateReference:delegateReference," +
		"updatedForMigration:updatedForMigration," +
		"code:code," +
		"reason:reason," +
		"request:request," +
		"shouldRetry:shouldRetry" +
	"}"))
}

public fun failedRequestDetails_fromJs(obj: FailedRequestDetailsJs): FailedRequestDetails {
	val entityId = obj.entityId
	val delegateReference = entityReferenceInGroup_fromJs(obj.delegateReference)
	val updatedForMigration = obj.updatedForMigration
	val code = numberToInt(obj.code, "obj.code")
	val reason = undefinedToNull(obj.reason)
	val request = obj.request?.let { nonNull1 ->
		delegateShareOptions_fromJs(nonNull1)
	}
	val shouldRetry = obj.shouldRetry
	return FailedRequestDetails(
		entityId = entityId,
		delegateReference = delegateReference,
		updatedForMigration = updatedForMigration,
		code = code,
		reason = reason,
		request = request,
		shouldRetry = shouldRetry,
	)
}
