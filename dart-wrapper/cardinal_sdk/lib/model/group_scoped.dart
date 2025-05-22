// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "group_scoped.freezed.dart";


@freezed
abstract class GroupScoped<E> with _$GroupScoped<E> {
	const factory GroupScoped({
		required E entity,
		required String groupId,
	}) = _GroupScoped;


	static Map<String, dynamic> encode<E>(GroupScoped<E> value, dynamic Function(E) encodeE) {
		Map<String, dynamic> entityAsMap = {
			"entity" : encodeE(value.entity),
			"groupId" : value.groupId
		};
		return entityAsMap;
	}

	static GroupScoped<E> fromJSON<E>(Map<String, dynamic> data, E Function(dynamic) decodeE) {
		return GroupScoped(
			entity: decodeE(data["entity"]),
			groupId: (data["groupId"] as String)
		);
	}
}