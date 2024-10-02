// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun idWithMandatoryRev_toJs(obj: IdWithMandatoryRev): IdWithMandatoryRevJs {
	val id = obj.id
	val rev = obj.rev
	return IdWithMandatoryRevJs(js("{" +
		"id:id," +
		"rev:rev" +
	"}"))
}

public fun idWithMandatoryRev_fromJs(obj: IdWithMandatoryRevJs): IdWithMandatoryRev {
	val id = obj.id
	val rev = obj.rev
	return IdWithMandatoryRev(
		id = id,
		rev = rev,
	)
}
