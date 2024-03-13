package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class DocumentStatus() {
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
