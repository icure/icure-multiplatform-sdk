// auto-generated file
package com.icure.sdk.js.model

import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.HasEncryptionMetadataJs
import com.icure.sdk.js.model.base.ICureDocumentJs
import com.icure.sdk.js.model.base.VersionableJs
import com.icure.sdk.js.model.embed.SecurityMetadataJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName

@JsName("IcureStub")
public external class IcureStubJs(
	partial: dynamic,
) : ICureDocumentJs<String>, VersionableJs<String>, HasEncryptionMetadataJs {
	override val id: String

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val endOfLife: Double?

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: dynamic

	override val delegations: dynamic

	override val encryptionKeys: dynamic

	override val securityMetadata: SecurityMetadataJs?
}
