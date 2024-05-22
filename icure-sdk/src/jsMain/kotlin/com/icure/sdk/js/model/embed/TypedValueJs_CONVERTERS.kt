package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.instantToNumber
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToInstant
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.specializations.base64String_fromJs
import com.icure.sdk.js.model.specializations.base64String_toJs
import com.icure.sdk.model.embed.DecryptedTypedValue
import com.icure.sdk.model.embed.EncryptedTypedValue
import com.icure.sdk.model.embed.TypedValue

public fun typedValue_toJs(obj: DecryptedTypedValue): DecryptedTypedValueJs {
	val type = obj.type?.let { nonNull1 ->
		typedValuesType_toJs(nonNull1)
	}
	val booleanValue = obj.booleanValue
	val integerValue = longToNumber(obj.integerValue)
	val doubleValue = obj.doubleValue
	val stringValue = obj.stringValue
	val dateValue = instantToNumber(obj.dateValue)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	return DecryptedTypedValueJs(js("{" +
		"type:type," +
		"booleanValue:booleanValue," +
		"integerValue:integerValue," +
		"doubleValue:doubleValue," +
		"stringValue:stringValue," +
		"dateValue:dateValue," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun typedValue_fromJs(obj: DecryptedTypedValueJs): DecryptedTypedValue {
	val type = obj.type?.let { nonNull1 ->
		typedValuesType_fromJs(nonNull1)
	}
	val booleanValue = obj.booleanValue
	val integerValue = numberToLong(obj.integerValue, "obj.integerValue")
	val doubleValue = obj.doubleValue
	val stringValue = obj.stringValue
	val dateValue = numberToInstant(obj.dateValue, "obj.dateValue")
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedTypedValue(
		type = type,
		booleanValue = booleanValue,
		integerValue = integerValue,
		doubleValue = doubleValue,
		stringValue = stringValue,
		dateValue = dateValue,
		encryptedSelf = encryptedSelf,
	)
}

public fun typedValue_toJs(obj: EncryptedTypedValue): EncryptedTypedValueJs {
	val type = obj.type?.let { nonNull1 ->
		typedValuesType_toJs(nonNull1)
	}
	val booleanValue = obj.booleanValue
	val integerValue = longToNumber(obj.integerValue)
	val doubleValue = obj.doubleValue
	val stringValue = obj.stringValue
	val dateValue = instantToNumber(obj.dateValue)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	return EncryptedTypedValueJs(js("{" +
		"type:type," +
		"booleanValue:booleanValue," +
		"integerValue:integerValue," +
		"doubleValue:doubleValue," +
		"stringValue:stringValue," +
		"dateValue:dateValue," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun typedValue_fromJs(obj: EncryptedTypedValueJs): EncryptedTypedValue {
	val type = obj.type?.let { nonNull1 ->
		typedValuesType_fromJs(nonNull1)
	}
	val booleanValue = obj.booleanValue
	val integerValue = numberToLong(obj.integerValue, "obj.integerValue")
	val doubleValue = obj.doubleValue
	val stringValue = obj.stringValue
	val dateValue = numberToInstant(obj.dateValue, "obj.dateValue")
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedTypedValue(
		type = type,
		booleanValue = booleanValue,
		integerValue = integerValue,
		doubleValue = doubleValue,
		stringValue = stringValue,
		dateValue = dateValue,
		encryptedSelf = encryptedSelf,
	)
}

public fun typedValue_toJs(obj: TypedValue): TypedValueJs = when (obj) {
	is EncryptedTypedValue -> typedValue_toJs(obj)
	is DecryptedTypedValue -> typedValue_toJs(obj)
}

public fun typedValue_fromJs(obj: TypedValueJs): TypedValue = if (obj.isEncrypted) {
	typedValue_fromJs(obj as EncryptedTypedValueJs)
} else {
	typedValue_fromJs(obj as DecryptedTypedValueJs)
}
