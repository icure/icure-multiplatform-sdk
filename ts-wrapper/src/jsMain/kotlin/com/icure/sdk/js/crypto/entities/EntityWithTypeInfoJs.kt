@file:JsQualifier("crypto")

package com.icure.sdk.js.crypto.entities

import com.icure.sdk.js.model.base.HasEncryptionMetadataJs

@JsName("EntityWithTypeInfo")
public external class EntityWithTypeInfoJs<T : HasEncryptionMetadataJs>(
	entity: T,
	type: String
) {
	public val entity: T

	public val type: String
}
