package com.icure.sdk.js.model.couchdb

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun docIdentifier_toJs(obj: DocIdentifier): DocIdentifierJs {
	val id = nullToUndefined(
		obj.id
	)
	val rev = nullToUndefined(
		obj.rev
	)
	return DocIdentifierJs(js("{" +
		"id:id," +
		"rev:rev" +
	"}"))
}

public fun docIdentifier_fromJs(obj: DocIdentifierJs): DocIdentifier {
	val id = undefinedToNull(obj.id)
	val rev = undefinedToNull(obj.rev)
	return DocIdentifier(
		id = id,
		rev = rev,
	)
}
