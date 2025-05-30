// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.base

import com.icure.cardinal.sdk.js.model.embed.AddressJs
import com.icure.cardinal.sdk.js.model.embed.PersonNameJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Person")
public external interface PersonJs : IdentifiableJs<String> {
	public val civility: String?

	public val gender: String?

	public val firstName: String?

	public val lastName: String?

	public val companyName: String?

	public val names: Array<out PersonNameJs>

	public val addresses: Array<out AddressJs>

	public val languages: Array<out String>
}
