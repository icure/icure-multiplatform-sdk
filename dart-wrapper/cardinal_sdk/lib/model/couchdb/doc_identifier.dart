// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "doc_identifier.freezed.dart";


@freezed
abstract class DocIdentifier with _$DocIdentifier {
	const factory DocIdentifier({
		@Default(null) String? id,
		@Default(null) String? rev,
	}) = _DocIdentifier;


	static Map<String, dynamic> encode(DocIdentifier value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev
		};
		return entityAsMap;
	}

	static DocIdentifier fromJSON(Map<String, dynamic> data) {
		return DocIdentifier(
			id: (data["id"] as String?),
			rev: (data["rev"] as String?)
		);
	}
}