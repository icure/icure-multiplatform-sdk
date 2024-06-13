package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.embed.address_fromJs
import com.icure.sdk.js.model.embed.address_toJs
import com.icure.sdk.model.Place
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun place_toJs(obj: Place): PlaceJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val name = nullToUndefined(
		obj.name
	)
	val address = nullToUndefined(
		obj.address?.let { nonNull1 ->
			address_toJs(nonNull1)
		}
	)
	return PlaceJs(js("{" +
		"id:id," +
		"rev:rev," +
		"deletionDate:deletionDate," +
		"name:name," +
		"address:address" +
	"}"))
}

public fun place_fromJs(obj: PlaceJs): Place {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val name = undefinedToNull(obj.name)
	val address = obj.address?.let { nonNull1 ->
		address_fromJs(nonNull1)
	}
	return Place(
		id = id,
		rev = rev,
		deletionDate = deletionDate,
		name = name,
		address = address,
	)
}
