// auto-generated file
import 'package:cardinal_sdk/model/couchdb/view.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "design_document.freezed.dart";


@freezed
abstract class DesignDocument with _$DesignDocument {
	const factory DesignDocument({
		required String id,
		@Default(null) String? rev,
		@Default({}) Map<String, String> revHistory,
		@Default(null) String? language,
		@Default({}) Map<String, View> views,
		@Default({}) Map<String, String> lists,
		@Default({}) Map<String, String> shows,
		@Default(null) Map<String, String>? updateHandlers,
		@Default({}) Map<String, String> filters,
	}) = _DesignDocument;


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
			id: (data["id"] as String),
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