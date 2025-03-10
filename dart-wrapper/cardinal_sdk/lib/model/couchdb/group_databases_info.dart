// auto-generated file
import 'package:cardinal_sdk/model/couchdb/database_info.dart';


class GroupDatabasesInfo {
	String groupId;
	List<DatabaseInfo> databasesInfo;
	int gcpStorageSize;
	GroupDatabasesInfo(
		this.groupId,
		this.databasesInfo,
		this.gcpStorageSize
		);

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
			(data["groupId"] as String),
			(data["databasesInfo"] as List<dynamic>).map((x0) => DatabaseInfo.fromJSON(x0) ).toList(),
			(data["gcpStorageSize"] as int)
		);
	}
}