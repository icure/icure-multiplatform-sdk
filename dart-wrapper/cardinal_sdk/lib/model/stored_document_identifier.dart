// auto-generated file
import 'package:cardinal_sdk/model/base/identifiable.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "stored_document_identifier.freezed.dart";


@freezed
abstract class StoredDocumentIdentifier with _$StoredDocumentIdentifier implements Identifiable<String> {
	const factory StoredDocumentIdentifier({
		required String id,
		required String rev,
	}) = _StoredDocumentIdentifier;


	static Map<String, dynamic> encode(StoredDocumentIdentifier value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev
		};
		return entityAsMap;
	}

	static StoredDocumentIdentifier fromJSON(Map<String, dynamic> data) {
		return StoredDocumentIdentifier(
			id: (data["id"] as String),
			rev: (data["rev"] as String)
		);
	}
}