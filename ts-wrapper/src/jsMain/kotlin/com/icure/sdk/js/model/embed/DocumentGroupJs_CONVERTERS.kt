package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.DocumentGroup
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun documentGroup_toJs(obj: DocumentGroup): DocumentGroupJs {
	val guid = obj.guid
	val name = obj.name
	return DocumentGroupJs(js("{" +
		"guid:guid," +
		"name:name" +
	"}"))
}

public fun documentGroup_fromJs(obj: DocumentGroupJs): DocumentGroup {
	val guid = obj.guid
	val name = obj.name
	return DocumentGroup(
		guid = guid,
		name = name,
	)
}
