package com.icure.sdk.js.model.couchdb

import com.icure.sdk.model.couchdb.SortDirection
import kotlin.String

public fun sortDirection_toJs(obj: SortDirection): String = obj.name

public fun sortDirection_fromJs(obj: String): SortDirection = when (obj) {
	"Asc" -> SortDirection.Asc
	"Desc" -> SortDirection.Desc
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.couchdb.SortDirection: $obj""")
}
