// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "token_with_group.freezed.dart";


@freezed
abstract class TokenWithGroup with _$TokenWithGroup {
	const factory TokenWithGroup({
		required String token,
		required String groupId,
		@Default(null) String? groupName,
	}) = _TokenWithGroup;


	static Map<String, dynamic> encode(TokenWithGroup value) {
		Map<String, dynamic> entityAsMap = {
			"token" : value.token,
			"groupId" : value.groupId,
			"groupName" : value.groupName
		};
		return entityAsMap;
	}

	static TokenWithGroup fromJSON(Map<String, dynamic> data) {
		return TokenWithGroup(
			token: (data["token"] as String),
			groupId: (data["groupId"] as String),
			groupName: (data["groupName"] as String?),
		);
	}
}