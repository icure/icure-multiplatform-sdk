package com.icure.cardinal.sdk.model.couchdb

import com.icure.cardinal.sdk.serialization.ZonedDateTimeSerializer
import com.icure.cardinal.sdk.utils.time.ZonedDateTime
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class ReplicationStats(
	public val revisionsChecked: Int? = null,
	public val missingRevisionsFound: Int? = null,
	public val docsRead: Int? = null,
	public val docsWritten: Int? = null,
	public val changesPending: Int? = null,
	public val docWriteFailures: Int? = null,
	public val checkpointedSourceSeq: String? = null,
	@Serializable(with = ZonedDateTimeSerializer::class)
	public val startTime: ZonedDateTime? = null,
	public val error: String? = null,
) {
	public val dtoSerialName: String
	// region ReplicationStats-ReplicationStats

	// endregion
}
