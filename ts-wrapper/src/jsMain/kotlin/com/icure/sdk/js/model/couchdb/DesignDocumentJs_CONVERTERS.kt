package com.icure.sdk.js.model.couchdb

import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.objectToMapNullsafe
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.couchdb.DesignDocument
import com.icure.sdk.model.couchdb.View
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun designDocument_toJs(obj: DesignDocument): DesignDocumentJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val revHistory = mapToObject(
		obj.revHistory,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val language = nullToUndefined(
		obj.language
	)
	val views = mapToObject(
		obj.views,
		{ x1: String ->
			x1
		},
		{ x1: View ->
			view_toJs(x1)
		},
	)
	val lists = mapToObject(
		obj.lists,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val shows = mapToObject(
		obj.shows,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val updateHandlers = nullToUndefined(
		mapToObject(
			obj.updateHandlers,
			{ x1: String ->
				x1
			},
			{ x1: String ->
				x1
			},
		)
	)
	val filters = mapToObject(
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
	val rev = undefinedToNull(obj.rev)
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
	val language = undefinedToNull(obj.language)
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
