package com.icure.sdk.model.couchdb

import com.icure.sdk.serialization.ZonedDateTimeSerializer
import com.icure.sdk.utils.time.ZonedDateTime
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class ReplicationStats(
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
)
