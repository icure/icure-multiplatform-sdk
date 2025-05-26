package com.icure.cardinal.sdk.model.security

import com.icure.cardinal.sdk.model.embed.AuthenticationClass
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.SerialName

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class ExternalJwtConfig(
	public val validationMethod: ValidationMethod,
	public val fieldSelector: FieldSelector,
	@DefaultValue("AuthenticationClassDto.EXTERNAL_AUTHENTICATION")
	public val authenticationClass: AuthenticationClass =
		AuthenticationClassDto.EXTERNAL_AUTHENTICATION,
	internal val dtoSerialName: String,
) {
	@Serializable
	public sealed interface ValidationMethod {
		@Serializable
		public data class PublicKey(
			public val key: String,
			internal val dtoSerialName: String,
		) : ValidationMethod

		@Serializable
		public data class Oidc(
			public val issureLocation: String,
			internal val dtoSerialName: String,
		) : ValidationMethod
	}

	@Serializable
	public sealed interface FieldSelector {
		@Serializable
		public data class LocalId(
			public val fieldName: String,
			internal val dtoSerialName: String,
		) : FieldSelector

		@Serializable
		public data class Email(
			public val fieldName: String,
			internal val dtoSerialName: String,
		) : FieldSelector

		@Serializable
		public data class MobilePhone(
			public val fieldName: String,
			internal val dtoSerialName: String,
		) : FieldSelector

		@Serializable
		public data class Username(
			public val fieldName: String,
			internal val dtoSerialName: String,
		) : FieldSelector

		@Serializable
		public data class Identifier(
			public val identifierAssigner: String,
			public val fieldName: String,
			internal val dtoSerialName: String,
		) : FieldSelector
	}
	// region ExternalJwtConfig-ExternalJwtConfig

	// endregion
}
