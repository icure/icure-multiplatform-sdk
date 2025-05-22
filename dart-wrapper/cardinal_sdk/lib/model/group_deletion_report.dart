// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "group_deletion_report.freezed.dart";


@freezed
abstract class GroupDeletionReport with _$GroupDeletionReport {
	const factory GroupDeletionReport({
		required String type,
		required String id,
		required String server,
	}) = _GroupDeletionReport;


	static Map<String, dynamic> encode(GroupDeletionReport value) {
		Map<String, dynamic> entityAsMap = {
			"type" : value.type,
			"id" : value.id,
			"server" : value.server
		};
		return entityAsMap;
	}

	static GroupDeletionReport fromJSON(Map<String, dynamic> data) {
		return GroupDeletionReport(
			type: (data["type"] as String),
			id: (data["id"] as String),
			server: (data["server"] as String)
		);
	}
}