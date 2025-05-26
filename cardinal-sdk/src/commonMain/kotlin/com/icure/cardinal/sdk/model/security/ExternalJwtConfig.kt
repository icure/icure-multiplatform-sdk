package com.icure.cardinal.sdk.model.security

import com.icure.cardinal.sdk.model.embed.AuthenticationClass
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class ExternalJwtConfig(
	public val validationMethod: ValidationMethod,
	public val fieldSelector: FieldSelector,
	@DefaultValue("AuthenticationClassDto.EXTERNAL_AUTHENTICATION")
	public val authenticationClass: AuthenticationClass =
		AuthenticationClassDto.EXTERNAL_AUTHENTICATION,
) {
	@Serializable
	public sealed interface ValidationMethod {
		@Serializable
		public data class PublicKey(
			public val key: String,
		) : ValidationMethod

		@Serializable
		public data class Oidc(
			public val issureLocation: String,
		) : ValidationMethod
	}

	@Serializable
	public sealed interface FieldSelector {
		@Serializable
		public data class LocalId(
			public val fieldName: String,
		) : FieldSelector

		@Serializable
		public data class Email(
			public val fieldName: String,
		) : FieldSelector

		@Serializable
		public data class MobilePhone(
			public val fieldName: String,
		) : FieldSelector

		@Serializable
		public data class Username(
			public val fieldName: String,
		) : FieldSelector

		@Serializable
		public data class Identifier(
			public val identifierAssigner: String,
			public val fieldName: String,
		) : FieldSelector
	}
}
