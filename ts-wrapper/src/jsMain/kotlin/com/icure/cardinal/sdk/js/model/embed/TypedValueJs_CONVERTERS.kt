// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.instantToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInstant
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.embed.DecryptedTypedValue
import com.icure.cardinal.sdk.model.embed.EncryptedTypedValue
import com.icure.cardinal.sdk.model.embed.TypedValue
import com.icure.cardinal.sdk.model.embed.TypedValuesType
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun typedValue_toJs(obj: DecryptedTypedValue): DecryptedTypedValueJs {
	val type = nullToUndefined(
		obj.type?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val booleanValue = nullToUndefined(
		obj.booleanValue
	)
	val integerValue = nullToUndefined(
		longToNumber(obj.integerValue)
	)
	val doubleValue = nullToUndefined(
		obj.doubleValue
	)
	val stringValue = nullToUndefined(
		obj.stringValue
	)
	val dateValue = nullToUndefined(
		instantToNumber(obj.dateValue)
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
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
		TypedValuesType.valueOf(nonNull1)
	}
	val booleanValue = undefinedToNull(obj.booleanValue)
	val integerValue = numberToLong(obj.integerValue, "obj.integerValue")
	val doubleValue = undefinedToNull(obj.doubleValue)
	val stringValue = undefinedToNull(obj.stringValue)
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

@Suppress("UNUSED_VARIABLE")
public fun typedValue_toJs(obj: EncryptedTypedValue): EncryptedTypedValueJs {
	val type = nullToUndefined(
		obj.type?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val booleanValue = nullToUndefined(
		obj.booleanValue
	)
	val integerValue = nullToUndefined(
		longToNumber(obj.integerValue)
	)
	val doubleValue = nullToUndefined(
		obj.doubleValue
	)
	val stringValue = nullToUndefined(
		obj.stringValue
	)
	val dateValue = nullToUndefined(
		instantToNumber(obj.dateValue)
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
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
		TypedValuesType.valueOf(nonNull1)
	}
	val booleanValue = undefinedToNull(obj.booleanValue)
	val integerValue = numberToLong(obj.integerValue, "obj.integerValue")
	val doubleValue = undefinedToNull(obj.doubleValue)
	val stringValue = undefinedToNull(obj.stringValue)
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

@Suppress("UNUSED_VARIABLE")
public fun typedValue_toJs(obj: TypedValue): TypedValueJs = when (obj) {
	is EncryptedTypedValue -> typedValue_toJs(obj)
	is DecryptedTypedValue -> typedValue_toJs(obj)
}

public fun typedValue_fromJs(obj: TypedValueJs): TypedValue = if (obj.isEncrypted) {
	typedValue_fromJs(obj as EncryptedTypedValueJs)
} else {
	typedValue_fromJs(obj as DecryptedTypedValueJs)
}
