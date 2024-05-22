package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.specializations.base64String_fromJs
import com.icure.sdk.js.model.specializations.base64String_toJs
import com.icure.sdk.model.embed.Address
import com.icure.sdk.model.embed.Annotation
import com.icure.sdk.model.embed.DecryptedAddress
import com.icure.sdk.model.embed.DecryptedTelecom
import com.icure.sdk.model.embed.EncryptedAddress
import com.icure.sdk.model.embed.EncryptedTelecom

public fun address_toJs(obj: DecryptedAddress): DecryptedAddressJs {
	val addressType = obj.addressType?.let { nonNull1 ->
		addressType_toJs(nonNull1)
	}
	val descr = obj.descr
	val street = obj.street
	val houseNumber = obj.houseNumber
	val postboxNumber = obj.postboxNumber
	val postalCode = obj.postalCode
	val city = obj.city
	val state = obj.state
	val country = obj.country
	val note = obj.note
	val notes = listToArray(
		obj.notes,
		{ x1: Annotation ->
			annotation_toJs(x1)
		},
	)
	val telecoms = listToArray(
		obj.telecoms,
		{ x1: DecryptedTelecom ->
			telecom_toJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	return DecryptedAddressJs(js("{" +
		"addressType:addressType," +
		"descr:descr," +
		"street:street," +
		"houseNumber:houseNumber," +
		"postboxNumber:postboxNumber," +
		"postalCode:postalCode," +
		"city:city," +
		"state:state," +
		"country:country," +
		"note:note," +
		"notes:notes," +
		"telecoms:telecoms," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun address_fromJs(obj: DecryptedAddressJs): DecryptedAddress {
	val addressType = obj.addressType?.let { nonNull1 ->
		addressType_fromJs(nonNull1)
	}
	val descr = obj.descr
	val street = obj.street
	val houseNumber = obj.houseNumber
	val postboxNumber = obj.postboxNumber
	val postalCode = obj.postalCode
	val city = obj.city
	val state = obj.state
	val country = obj.country
	val note = obj.note
	val notes = arrayToList(
		obj.notes,
		"obj.notes",
		{ x1: AnnotationJs ->
			annotation_fromJs(x1)
		},
	)
	val telecoms = arrayToList(
		obj.telecoms,
		"obj.telecoms",
		{ x1: DecryptedTelecomJs ->
			telecom_fromJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedAddress(
		addressType = addressType,
		descr = descr,
		street = street,
		houseNumber = houseNumber,
		postboxNumber = postboxNumber,
		postalCode = postalCode,
		city = city,
		state = state,
		country = country,
		note = note,
		notes = notes,
		telecoms = telecoms,
		encryptedSelf = encryptedSelf,
	)
}

public fun address_toJs(obj: EncryptedAddress): EncryptedAddressJs {
	val addressType = obj.addressType?.let { nonNull1 ->
		addressType_toJs(nonNull1)
	}
	val descr = obj.descr
	val street = obj.street
	val houseNumber = obj.houseNumber
	val postboxNumber = obj.postboxNumber
	val postalCode = obj.postalCode
	val city = obj.city
	val state = obj.state
	val country = obj.country
	val note = obj.note
	val notes = listToArray(
		obj.notes,
		{ x1: Annotation ->
			annotation_toJs(x1)
		},
	)
	val telecoms = listToArray(
		obj.telecoms,
		{ x1: EncryptedTelecom ->
			telecom_toJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	return EncryptedAddressJs(js("{" +
		"addressType:addressType," +
		"descr:descr," +
		"street:street," +
		"houseNumber:houseNumber," +
		"postboxNumber:postboxNumber," +
		"postalCode:postalCode," +
		"city:city," +
		"state:state," +
		"country:country," +
		"note:note," +
		"notes:notes," +
		"telecoms:telecoms," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun address_fromJs(obj: EncryptedAddressJs): EncryptedAddress {
	val addressType = obj.addressType?.let { nonNull1 ->
		addressType_fromJs(nonNull1)
	}
	val descr = obj.descr
	val street = obj.street
	val houseNumber = obj.houseNumber
	val postboxNumber = obj.postboxNumber
	val postalCode = obj.postalCode
	val city = obj.city
	val state = obj.state
	val country = obj.country
	val note = obj.note
	val notes = arrayToList(
		obj.notes,
		"obj.notes",
		{ x1: AnnotationJs ->
			annotation_fromJs(x1)
		},
	)
	val telecoms = arrayToList(
		obj.telecoms,
		"obj.telecoms",
		{ x1: EncryptedTelecomJs ->
			telecom_fromJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedAddress(
		addressType = addressType,
		descr = descr,
		street = street,
		houseNumber = houseNumber,
		postboxNumber = postboxNumber,
		postalCode = postalCode,
		city = city,
		state = state,
		country = country,
		note = note,
		notes = notes,
		telecoms = telecoms,
		encryptedSelf = encryptedSelf,
	)
}

public fun address_toJs(obj: Address): AddressJs = when (obj) {
	is EncryptedAddress -> address_toJs(obj)
	is DecryptedAddress -> address_toJs(obj)
}

public fun address_fromJs(obj: AddressJs): Address = if (obj.isEncrypted) {
	address_fromJs(obj as EncryptedAddressJs)
} else {
	address_fromJs(obj as DecryptedAddressJs)
}
