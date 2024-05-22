package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.FrontEndMigrationStatus
import kotlin.String

public fun frontEndMigrationStatus_toJs(obj: FrontEndMigrationStatus): String = obj.name

public fun frontEndMigrationStatus_fromJs(obj: String): FrontEndMigrationStatus = when (obj) {
	"Started" -> FrontEndMigrationStatus.Started
	"Paused" -> FrontEndMigrationStatus.Paused
	"Error" -> FrontEndMigrationStatus.Error
	"Success" -> FrontEndMigrationStatus.Success
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.FrontEndMigrationStatus: $obj""")
}
