// auto-generated file
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/time_table.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';


class TimeTableBasicApi {
	final String _sdkId;
	TimeTableBasicApi(this._sdkId);

	Future<List<String>> matchTimeTablesBy(BaseFilterOptions<TimeTable> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTableBasic.matchTimeTablesBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchTimeTablesBySorted(BaseSortableFilterOptions<TimeTable> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTableBasic.matchTimeTablesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedTimeTable>> filterTimeTablesBy(BaseFilterOptions<TimeTable> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTableBasic.filterTimeTablesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedTimeTable>> filterTimeTablesBySorted(BaseSortableFilterOptions<TimeTable> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTableBasic.filterTimeTablesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteTimeTableById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTableBasic.deleteTimeTableById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteTimeTablesByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTableBasic.deleteTimeTablesByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeTimeTableById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTableBasic.purgeTimeTableById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteTimeTable(TimeTable timeTable) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTableBasic.deleteTimeTable(
			_sdkId,
			timeTable,
		);
	}

	Future<List<DocIdentifier>> deleteTimeTables(List<TimeTable> timeTables) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTableBasic.deleteTimeTables(
			_sdkId,
			timeTables,
		);
	}

	Future<void> purgeTimeTable(TimeTable timeTable) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTableBasic.purgeTimeTable(
			_sdkId,
			timeTable,
		);
	}

	Future<TimeTable> undeleteTimeTable(TimeTable timeTable) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTableBasic.undeleteTimeTable(
			_sdkId,
			timeTable,
		);
	}

	Future<EncryptedTimeTable> modifyTimeTable(EncryptedTimeTable entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTableBasic.modifyTimeTable(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedTimeTable> undeleteTimeTableById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTableBasic.undeleteTimeTableById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedTimeTable> getTimeTable(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTableBasic.getTimeTable(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedTimeTable>> getTimeTables(List<String> timeTableIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTableBasic.getTimeTables(
			_sdkId,
			timeTableIds,
		);
	}
}