package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.DocumentStatus
import kotlin.String

public fun documentStatus_toJs(obj: DocumentStatus): String = obj.name

public fun documentStatus_fromJs(obj: String): DocumentStatus = when (obj) {
	"Draft" -> DocumentStatus.Draft
	"Finalized" -> DocumentStatus.Finalized
	"PendingReview" -> DocumentStatus.PendingReview
	"Reviewed" -> DocumentStatus.Reviewed
	"PendingSignature" -> DocumentStatus.PendingSignature
	"Signed" -> DocumentStatus.Signed
	"Canceled" -> DocumentStatus.Canceled
	"Sent" -> DocumentStatus.Sent
	"Delivered" -> DocumentStatus.Delivered
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.DocumentStatus: $obj""")
}
