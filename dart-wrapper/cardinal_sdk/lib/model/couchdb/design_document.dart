// auto-generated file
import 'package:cardinal_sdk/model/couchdb/view.dart';


class DesignDocument {
	String id;
	String? rev = null;
	Map<String, String> revHistory = {};
	String? language = null;
	Map<String, View> views = {};
	Map<String, String> lists = {};
	Map<String, String> shows = {};
	Map<String, String>? updateHandlers = null;
	Map<String, String> filters = {};
	DesignDocument(
		this.id,
		{
			String? rev,
			Map<String, String>? revHistory,
			String? language,
			Map<String, View>? views,
			Map<String, String>? lists,
			Map<String, String>? shows,
			Map<String, String>? updateHandlers,
			Map<String, String>? filters
		}) : rev = rev ?? null,
		revHistory = revHistory ?? {},
		language = language ?? null,
		views = views ?? {},
		lists = lists ?? {},
		shows = shows ?? {},
		updateHandlers = updateHandlers ?? null,
		filters = filters ?? {};

	static Map<String, dynamic> encode(DesignDocument value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"revHistory" : value.revHistory.map((k0, v0) => MapEntry(k0, v0)),
			"language" : value.language,
			"views" : value.views.map((k0, v0) => MapEntry(k0, View.encode(v0))),
			"lists" : value.lists.map((k0, v0) => MapEntry(k0, v0)),
			"shows" : value.shows.map((k0, v0) => MapEntry(k0, v0)),
			"updateHandlers" : value.updateHandlers?.map((k0, v0) => MapEntry(k0, v0)),
			"filters" : value.filters.map((k0, v0) => MapEntry(k0, v0))
		};
		return entityAsMap;
	}

	static DesignDocument fromJSON(Map<String, dynamic> data) {
		return DesignDocument(
			(data["id"] as String),
			rev: (data["rev"] as String?),
			revHistory: (data["revHistory"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			language: (data["language"] as String?),
			views: (data["views"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), View.fromJSON(v0))),
			lists: (data["lists"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			shows: (data["shows"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			updateHandlers: (data["updateHandlers"] as Map<String, dynamic>?)?.map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			filters: (data["filters"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
		);
	}
}