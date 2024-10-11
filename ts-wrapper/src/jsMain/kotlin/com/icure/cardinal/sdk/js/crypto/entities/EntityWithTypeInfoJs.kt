@file:JsQualifier("crypto")

package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.js.model.base.HasEncryptionMetadataJs

@JsName("EntityWithTypeInfo")
public external class EntityWithTypeInfoJs<T : HasEncryptionMetadataJs>(
	entity: T,
	type: String
) {
	public val entity: T

	public val type: String
}
