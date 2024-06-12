package com.icure.sdk.js.model.security

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.model.security.Operation
import com.icure.sdk.model.security.OperationToken

public fun operationToken_toJs(obj: OperationToken): OperationTokenJs {
	val tokenHash = obj.tokenHash
	val creationTime = longToNumber(obj.creationTime)
	val validity = longToNumber(obj.validity)
	val operation = obj.operation.name
	val description = obj.description
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
	val description = obj.description
	return OperationToken(
		tokenHash = tokenHash,
		creationTime = creationTime,
		validity = validity,
		operation = operation,
		description = description,
	)
}
