// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/model/time_table.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';


class TimeTableApi {
	final String _sdkId;
	final Object _dartSdk;
	TimeTableApi(
		this._sdkId,
		this._dartSdk
		);

	Future<DocIdentifier> deleteTimeTableById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.deleteTimeTableById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteTimeTablesByIds(List<StoredDocumentIdentifier> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.deleteTimeTablesByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeTimeTableById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.purgeTimeTableById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteTimeTable(TimeTable timeTable) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.deleteTimeTable(
			_sdkId,
			timeTable,
		);
	}

	Future<List<DocIdentifier>> deleteTimeTables(List<TimeTable> timeTables) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.deleteTimeTables(
			_sdkId,
			timeTables,
		);
	}

	Future<void> purgeTimeTable(TimeTable timeTable) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.purgeTimeTable(
			_sdkId,
			timeTable,
		);
	}

	Future<TimeTable> undeleteTimeTable(TimeTable timeTable) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.undeleteTimeTable(
			_sdkId,
			timeTable,
		);
	}

	Future<TimeTable> modifyTimeTable(TimeTable entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.modifyTimeTable(
			_sdkId,
			entity,
		);
	}

	Future<TimeTable> undeleteTimeTableById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.undeleteTimeTableById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<TimeTable?> getTimeTable(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.getTimeTable(
			_sdkId,
			entityId,
		);
	}

	Future<List<TimeTable>> getTimeTables(List<String> timeTableIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.getTimeTables(
			_sdkId,
			timeTableIds,
		);
	}

	Future<PaginatedListIterator<TimeTable>> filterTimeTablesBy(BaseFilterOptions<TimeTable> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.filterTimeTablesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<TimeTable>> filterTimeTablesBySorted(BaseSortableFilterOptions<TimeTable> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.filterTimeTablesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<TimeTable> createTimeTable(TimeTable entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.createTimeTable(
			_sdkId,
			entity,
		);
	}

	Future<List<String>> matchTimeTablesBy(BaseFilterOptions<TimeTable> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.matchTimeTablesBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchTimeTablesBySorted(BaseSortableFilterOptions<TimeTable> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.matchTimeTablesBySorted(
			_sdkId,
			filter,
		);
	}
}