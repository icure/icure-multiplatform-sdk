// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.model.GroupDeletionReport
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun groupDeletionReport_toJs(obj: GroupDeletionReport): GroupDeletionReportJs {
	val type = obj.type
	val id = obj.id
	val server = obj.server
	return GroupDeletionReportJs(js("{" +
		"type:type," +
		"id:id," +
		"server:server" +
	"}"))
}

public fun groupDeletionReport_fromJs(obj: GroupDeletionReportJs): GroupDeletionReport {
	val type = obj.type
	val id = obj.id
	val server = obj.server
	return GroupDeletionReport(
		type = type,
		id = id,
		server = server,
	)
}
