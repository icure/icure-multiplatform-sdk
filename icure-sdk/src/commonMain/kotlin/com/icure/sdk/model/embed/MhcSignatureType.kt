package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class MhcSignatureType() {
	@SerialName("holderEid")
	HolderEid,

	@SerialName("holderPaper")
	HolderPaper,

	@SerialName("legalrepresentativeEid")
	LegalrepresentativeEid,

	@SerialName("legalrepresentativePaper")
	LegalrepresentativePaper,
}
