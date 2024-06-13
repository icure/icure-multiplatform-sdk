package com.icure.sdk.js.model

import com.icure.sdk.model.IdWithRev
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun idWithRev_toJs(obj: IdWithRev): IdWithRevJs {
	val id = obj.id
	val rev = obj.rev
	return IdWithRevJs(js("{" +
		"id:id," +
		"rev:rev" +
	"}"))
}

public fun idWithRev_fromJs(obj: IdWithRevJs): IdWithRev {
	val id = obj.id
	val rev = obj.rev
	return IdWithRev(
		id = id,
		rev = rev,
	)
}
