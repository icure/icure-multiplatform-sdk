// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model

import com.icure.sdk.js.model.base.StoredDocumentJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("FrontEndMigration")
public external class FrontEndMigrationJs(
	partial: dynamic,
) : StoredDocumentJs {
	override val id: String

	override val rev: String?

	override val deletionDate: Double?

	public val name: String?

	public val startDate: Double?

	public val endDate: Double?

	public val status: String?

	public val logs: String?

	public val userId: String?

	public val startKey: String?

	public val startKeyDocId: String?

	public val processCount: Double?

	public val properties: Array<DecryptedPropertyStubJs>
}
