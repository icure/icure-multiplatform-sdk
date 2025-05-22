// auto-generated file
import 'package:cardinal_sdk/model/couchdb/database_info.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "group_databases_info.freezed.dart";


@freezed
abstract class GroupDatabasesInfo with _$GroupDatabasesInfo {
	const factory GroupDatabasesInfo({
		required String groupId,
		required List<DatabaseInfo> databasesInfo,
		required int gcpStorageSize,
	}) = _GroupDatabasesInfo;


	static Map<String, dynamic> encode(GroupDatabasesInfo value) {
		Map<String, dynamic> entityAsMap = {
			"groupId" : value.groupId,
			"databasesInfo" : value.databasesInfo.map((x0) => DatabaseInfo.encode(x0)).toList(),
			"gcpStorageSize" : value.gcpStorageSize
		};
		return entityAsMap;
	}

	static GroupDatabasesInfo fromJSON(Map<String, dynamic> data) {
		return GroupDatabasesInfo(
			groupId: (data["groupId"] as String),
			databasesInfo: (data["databasesInfo"] as List<dynamic>).map((x0) => DatabaseInfo.fromJSON(x0) ).toList(),
			gcpStorageSize: (data["gcpStorageSize"] as int)
		);
	}
}