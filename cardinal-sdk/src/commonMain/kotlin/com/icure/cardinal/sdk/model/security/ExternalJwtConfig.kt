package com.icure.cardinal.sdk.model.security

import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class ExternalJwtConfig(
	public val publicKey: Base64String,
	public val id: String? = null,
	public val emailField: String? = null,
	public val loginField: String? = null,
	public val mobilePhoneField: String? = null,
	public val identifierField: IdentifierSelector? = null,
) {
	// region ExternalJwtConfig-ExternalJwtConfig

	// endregion
}
