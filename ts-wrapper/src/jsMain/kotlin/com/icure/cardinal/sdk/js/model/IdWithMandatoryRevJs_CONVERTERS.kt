// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun idWithMandatoryRev_toJs(obj: StoredDocumentIdentifier): IdWithMandatoryRevJs {
	val id = obj.id
	val rev = obj.rev
	return IdWithMandatoryRevJs(js("{" +
		"id:id," +
		"rev:rev" +
	"}"))
}

public fun idWithMandatoryRev_fromJs(obj: IdWithMandatoryRevJs): StoredDocumentIdentifier {
	val id = obj.id
	val rev = obj.rev
	return StoredDocumentIdentifier(
		id = id,
		rev = rev,
	)
}
