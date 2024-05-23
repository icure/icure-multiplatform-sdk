package com.icure.sdk.js.model.couchdb

import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.objectToMapNullsafe
import com.icure.sdk.model.couchdb.DesignDocument
import com.icure.sdk.model.couchdb.View
import kotlin.String

public fun designDocument_toJs(obj: DesignDocument): DesignDocumentJs {
	val id = obj.id
	val rev = obj.rev
	val revHistory = mapToObject<_, _, String>(
		obj.revHistory,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val language = obj.language
	val views = mapToObject<_, _, ViewJs>(
		obj.views,
		{ x1: String ->
			x1
		},
		{ x1: View ->
			view_toJs(x1)
		},
	)
	val lists = mapToObject<_, _, String>(
		obj.lists,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val shows = mapToObject<_, _, String>(
		obj.shows,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val updateHandlers = mapToObject<_, _, String>(
		obj.updateHandlers,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val filters = mapToObject<_, _, String>(
		obj.filters,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	return DesignDocumentJs(js("{" +
		"id:id," +
		"rev:rev," +
		"revHistory:revHistory," +
		"language:language," +
		"views:views," +
		"lists:lists," +
		"shows:shows," +
		"updateHandlers:updateHandlers," +
		"filters:filters" +
	"}"))
}

public fun designDocument_fromJs(obj: DesignDocumentJs): DesignDocument {
	val id = obj.id
	val rev = obj.rev
	val revHistory = objectToMap(
		obj.revHistory,
		"obj.revHistory",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val language = obj.language
	val views = objectToMap(
		obj.views,
		"obj.views",
		{ x1: String ->
			x1
		},
		{ x1: ViewJs ->
			view_fromJs(x1)
		},
	)
	val lists = objectToMap(
		obj.lists,
		"obj.lists",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val shows = objectToMap(
		obj.shows,
		"obj.shows",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val updateHandlers = objectToMapNullsafe(
		obj.updateHandlers,
		"obj.updateHandlers",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val filters = objectToMap(
		obj.filters,
		"obj.filters",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	return DesignDocument(
		id = id,
		rev = rev,
		revHistory = revHistory,
		language = language,
		views = views,
		lists = lists,
		shows = shows,
		updateHandlers = updateHandlers,
		filters = filters,
	)
}
