package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class DocumentStatus() {
	@SerialName("draft")
	Draft,

	@SerialName("finalized")
	Finalized,

	@SerialName("pending_review")
	PendingReview,

	@SerialName("reviewed")
	Reviewed,

	@SerialName("pending_signature")
	PendingSignature,

	@SerialName("signed")
	Signed,

	@SerialName("canceled")
	Canceled,

	@SerialName("sent")
	Sent,

	@SerialName("delivered")
	Delivered,
}
