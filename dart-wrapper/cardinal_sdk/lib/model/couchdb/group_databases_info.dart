// This file is auto-generated
import 'package:cardinal_sdk/model/couchdb/database_info.dart';


class GroupDatabasesInfo {
	String groupId;
	List<DatabaseInfo> databasesInfo;
	int gcpStorageSize;

	GroupDatabasesInfo({
		required this.groupId,
		required this.databasesInfo,
		required this.gcpStorageSize
	});

	static Map<String, dynamic> encode(GroupDatabasesInfo value) {
		Map<String, dynamic> entityAsMap = {
			"groupId" : value.groupId,
			"databasesInfo" : value.databasesInfo.map((x0) => DatabaseInfo.encode(x0)),
			"gcpStorageSize" : value.gcpStorageSize
		};
		return entityAsMap;
	}
}