package com.icure.sdk.js.model.couchdb

import com.icure.sdk.model.couchdb.DocIdentifier

public fun docIdentifier_toJs(obj: DocIdentifier): DocIdentifierJs {
	val id = obj.id
	val rev = obj.rev
	return DocIdentifierJs(js("{" +
		"id:id," +
		"rev:rev" +
	"}"))
}

public fun docIdentifier_fromJs(obj: DocIdentifierJs): DocIdentifier {
	val id = obj.id
	val rev = obj.rev
	return DocIdentifier(
		id = id,
		rev = rev,
	)
}
