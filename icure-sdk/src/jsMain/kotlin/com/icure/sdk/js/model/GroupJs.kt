// auto-generated file
package com.icure.sdk.js.model

import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.HasTagsJs
import com.icure.sdk.js.model.base.StoredDocumentJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName

@JsName("Group")
public external class GroupJs(
	partial: dynamic,
) : StoredDocumentJs, HasTagsJs {
	override val id: String

	override val rev: String?

	override val deletionDate: Double?

	override val tags: Array<CodeStubJs>

	public val name: String?

	public val password: String?

	public val servers: Array<String>?

	public val superAdmin: Boolean

	public val properties: Array<DecryptedPropertyStubJs>

	public val defaultUserRoles: dynamic

	public val operationTokens: dynamic

	public val sharedEntities: dynamic

	public val minimumKrakenVersion: String?

	public val minimumAuthenticationClassForElevatedPrivileges: String

	public val superGroup: String?
}
