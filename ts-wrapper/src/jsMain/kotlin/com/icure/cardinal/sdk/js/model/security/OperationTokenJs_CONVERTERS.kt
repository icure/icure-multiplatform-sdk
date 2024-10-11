// auto-generated file
package com.icure.cardinal.sdk.js.model.security

import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.security.Operation
import com.icure.cardinal.sdk.model.security.OperationToken
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun operationToken_toJs(obj: OperationToken): OperationTokenJs {
	val tokenHash = obj.tokenHash
	val creationTime = longToNumber(obj.creationTime)
	val validity = longToNumber(obj.validity)
	val operation = obj.operation.name
	val description = nullToUndefined(
		obj.description
	)
	return OperationTokenJs(js("{" +
		"tokenHash:tokenHash," +
		"creationTime:creationTime," +
		"validity:validity," +
		"operation:operation," +
		"description:description" +
	"}"))
}

public fun operationToken_fromJs(obj: OperationTokenJs): OperationToken {
	val tokenHash = obj.tokenHash
	val creationTime = numberToLong(obj.creationTime, "obj.creationTime")
	val validity = numberToLong(obj.validity, "obj.validity")
	val operation = Operation.valueOf(obj.operation)
	val description = undefinedToNull(obj.description)
	return OperationToken(
		tokenHash = tokenHash,
		creationTime = creationTime,
		validity = validity,
		operation = operation,
		description = description,
	)
}
