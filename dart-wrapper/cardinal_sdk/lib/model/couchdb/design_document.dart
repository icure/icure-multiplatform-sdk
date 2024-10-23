// auto-generated file
import 'package:cardinal_sdk/model/couchdb/view.dart';


class DesignDocument {
	String id;
	String? rev;
	Map<String, String> revHistory = {};
	String? language;
	Map<String, View> views = {};
	Map<String, String> lists = {};
	Map<String, String> shows = {};
	Map<String, String>? updateHandlers;
	Map<String, String> filters = {};
	DesignDocument(
		this.id,
		{
			this.rev,
			this.language,
			this.updateHandlers,
			Map<String, String>? revHistory,
			Map<String, View>? views,
			Map<String, String>? lists,
			Map<String, String>? shows,
			Map<String, String>? filters
		}) : revHistory = revHistory ?? {},
		views = views ?? {},
		lists = lists ?? {},
		shows = shows ?? {},
		filters = filters ?? {};

	factory DesignDocument.fromJSON(Map<String, dynamic> data) {
		return DesignDocument(
			data["id"],
			rev: data["rev"],
			revHistory: data["revHistory"].map((k0, v0) => MapEntry(k0, v0)),
			language: data["language"],
			views: data["views"].map((k0, v0) => MapEntry(k0, View.fromJSON(v0))),
			lists: data["lists"].map((k0, v0) => MapEntry(k0, v0)),
			shows: data["shows"].map((k0, v0) => MapEntry(k0, v0)),
			updateHandlers: data["updateHandlers"]?.map((k0, v0) => MapEntry(k0, v0)),
			filters: data["filters"].map((k0, v0) => MapEntry(k0, v0)),
		);
	}

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
}