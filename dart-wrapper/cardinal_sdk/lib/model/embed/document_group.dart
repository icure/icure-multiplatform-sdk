// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "document_group.freezed.dart";


@freezed
abstract class DocumentGroup with _$DocumentGroup {
	const factory DocumentGroup({
		@Default(null) String? guid,
		@Default(null) String? name,
	}) = _DocumentGroup;


	static Map<String, dynamic> encode(DocumentGroup value) {
		Map<String, dynamic> entityAsMap = {
			"guid" : value.guid,
			"name" : value.name
		};
		return entityAsMap;
	}

	static DocumentGroup fromJSON(Map<String, dynamic> data) {
		return DocumentGroup(
			guid: (data["guid"] as String?),
			name: (data["name"] as String?)
		);
	}
}