package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.embed.DocumentGroup
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun documentGroup_toJs(obj: DocumentGroup): DocumentGroupJs {
	val guid = nullToUndefined(
		obj.guid
	)
	val name = nullToUndefined(
		obj.name
	)
	return DocumentGroupJs(js("{" +
		"guid:guid," +
		"name:name" +
	"}"))
}

public fun documentGroup_fromJs(obj: DocumentGroupJs): DocumentGroup {
	val guid = undefinedToNull(obj.guid)
	val name = undefinedToNull(obj.name)
	return DocumentGroup(
		guid = guid,
		name = name,
	)
}
