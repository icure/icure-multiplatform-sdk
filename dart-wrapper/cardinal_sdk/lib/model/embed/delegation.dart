// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
part "delegation.freezed.dart";


@freezed
abstract class Delegation with _$Delegation {
	const factory Delegation({
		@Default(null) String? owner,
		@Default(null) String? delegatedTo,
		@Default(null) HexString? key,
		@Default([]) List<String> tags,
	}) = _Delegation;


	static Map<String, dynamic> encode(Delegation value) {
		Map<String, dynamic> entityAsMap = {
			"owner" : value.owner,
			"delegatedTo" : value.delegatedTo,
			"key" : value.key,
			"tags" : value.tags.map((x0) => x0).toList()
		};
		return entityAsMap;
	}

	static Delegation fromJSON(Map<String, dynamic> data) {
		return Delegation(
			owner: (data["owner"] as String?),
			delegatedTo: (data["delegatedTo"] as String?),
			key: (data["key"] as HexString?),
			tags: (data["tags"] as List<dynamic>).map((x0) => (x0 as String) ).toList()
		);
	}
}