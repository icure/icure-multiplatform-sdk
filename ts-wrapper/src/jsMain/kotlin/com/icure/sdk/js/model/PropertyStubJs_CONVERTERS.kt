package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.embed.typedValue_fromJs
import com.icure.sdk.js.model.embed.typedValue_toJs
import com.icure.sdk.js.model.specializations.base64String_fromJs
import com.icure.sdk.js.model.specializations.base64String_toJs
import com.icure.sdk.model.DecryptedPropertyStub
import com.icure.sdk.model.EncryptedPropertyStub
import com.icure.sdk.model.PropertyStub
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun propertyStub_toJs(obj: DecryptedPropertyStub): DecryptedPropertyStubJs {
	val id = obj.id
	val type = obj.type?.let { nonNull1 ->
		propertyTypeStub_toJs(nonNull1)
	}
	val typedValue = obj.typedValue?.let { nonNull1 ->
		typedValue_toJs(nonNull1)
	}
	val deletionDate = longToNumber(obj.deletionDate)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	return DecryptedPropertyStubJs(js("{" +
		"id:id," +
		"type:type," +
		"typedValue:typedValue," +
		"deletionDate:deletionDate," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun propertyStub_fromJs(obj: DecryptedPropertyStubJs): DecryptedPropertyStub {
	val id = obj.id
	val type = obj.type?.let { nonNull1 ->
		propertyTypeStub_fromJs(nonNull1)
	}
	val typedValue = obj.typedValue?.let { nonNull1 ->
		typedValue_fromJs(nonNull1)
	}
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedPropertyStub(
		id = id,
		type = type,
		typedValue = typedValue,
		deletionDate = deletionDate,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun propertyStub_toJs(obj: EncryptedPropertyStub): EncryptedPropertyStubJs {
	val id = obj.id
	val type = obj.type?.let { nonNull1 ->
		propertyTypeStub_toJs(nonNull1)
	}
	val typedValue = obj.typedValue?.let { nonNull1 ->
		typedValue_toJs(nonNull1)
	}
	val deletionDate = longToNumber(obj.deletionDate)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	return EncryptedPropertyStubJs(js("{" +
		"id:id," +
		"type:type," +
		"typedValue:typedValue," +
		"deletionDate:deletionDate," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun propertyStub_fromJs(obj: EncryptedPropertyStubJs): EncryptedPropertyStub {
	val id = obj.id
	val type = obj.type?.let { nonNull1 ->
		propertyTypeStub_fromJs(nonNull1)
	}
	val typedValue = obj.typedValue?.let { nonNull1 ->
		typedValue_fromJs(nonNull1)
	}
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedPropertyStub(
		id = id,
		type = type,
		typedValue = typedValue,
		deletionDate = deletionDate,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun propertyStub_toJs(obj: PropertyStub): PropertyStubJs = when (obj) {
	is EncryptedPropertyStub -> propertyStub_toJs(obj)
	is DecryptedPropertyStub -> propertyStub_toJs(obj)
}

public fun propertyStub_fromJs(obj: PropertyStubJs): PropertyStub = if (obj.isEncrypted) {
	propertyStub_fromJs(obj as EncryptedPropertyStubJs)
} else {
	propertyStub_fromJs(obj as DecryptedPropertyStubJs)
}
