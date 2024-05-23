// auto-generated file
package com.icure.sdk.js.model.couchdb

import kotlin.Double
import kotlin.String
import kotlin.js.JsName

@JsName("ReplicationStats")
public external class ReplicationStatsJs(
	partial: dynamic,
) {
	public val revisionsChecked: Double?

	public val missingRevisionsFound: Double?

	public val docsRead: Double?

	public val docsWritten: Double?

	public val changesPending: Double?

	public val docWriteFailures: Double?

	public val checkpointedSourceSeq: String?

	public val startTime: String?

	public val error: String?
}
