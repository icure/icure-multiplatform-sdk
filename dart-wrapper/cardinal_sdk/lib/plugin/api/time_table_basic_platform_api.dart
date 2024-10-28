// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/time_table.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';


class TimeTableBasicPlatformApi {
	MethodChannel _methodChannel;
	TimeTableBasicPlatformApi(this._methodChannel);

	Future<List<String>> matchTimeTablesBy(String sdkId, BaseFilterOptions<TimeTable> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableBasicApi.matchTimeTablesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchTimeTablesBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchTimeTablesBySorted(String sdkId, BaseSortableFilterOptions<TimeTable> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableBasicApi.matchTimeTablesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchTimeTablesBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<PaginatedListIterator<EncryptedTimeTable>> filterTimeTablesBy(String sdkId, BaseFilterOptions<TimeTable> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableBasicApi.filterTimeTablesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterTimeTablesBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedTimeTable.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedTimeTable>> filterTimeTablesBySorted(String sdkId, BaseSortableFilterOptions<TimeTable> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableBasicApi.filterTimeTablesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterTimeTablesBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedTimeTable.fromJSON(x0));
	}

	Future<DocIdentifier> deleteTimeTableById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableBasicApi.deleteTimeTableById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteTimeTableById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteTimeTablesByIds(String sdkId, List<IdWithMandatoryRev> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableBasicApi.deleteTimeTablesByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => IdWithMandatoryRev.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteTimeTablesByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeTimeTableById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableBasicApi.purgeTimeTableById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
	}

	Future<DocIdentifier> deleteTimeTable(String sdkId, TimeTable timeTable) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableBasicApi.deleteTimeTable',
			{
				"sdkId": sdkId,
				"timeTable": jsonEncode(TimeTable.encode(timeTable)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteTimeTable");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteTimeTables(String sdkId, List<TimeTable> timeTables) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableBasicApi.deleteTimeTables',
			{
				"sdkId": sdkId,
				"timeTables": jsonEncode(timeTables.map((x0) => TimeTable.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteTimeTables");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeTimeTable(String sdkId, TimeTable timeTable) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableBasicApi.purgeTimeTable',
			{
				"sdkId": sdkId,
				"timeTable": jsonEncode(TimeTable.encode(timeTable)),
			}
		);
	}

	Future<TimeTable> undeleteTimeTable(String sdkId, TimeTable timeTable) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableBasicApi.undeleteTimeTable',
			{
				"sdkId": sdkId,
				"timeTable": jsonEncode(TimeTable.encode(timeTable)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteTimeTable");
		final parsedResJson = jsonDecode(res);
		return TimeTable.fromJSON(parsedResJson);
	}

	Future<EncryptedTimeTable> modifyTimeTable(String sdkId, EncryptedTimeTable entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableBasicApi.modifyTimeTable',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedTimeTable.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyTimeTable");
		final parsedResJson = jsonDecode(res);
		return EncryptedTimeTable.fromJSON(parsedResJson);
	}

	Future<EncryptedTimeTable> undeleteTimeTableById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableBasicApi.undeleteTimeTableById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteTimeTableById");
		final parsedResJson = jsonDecode(res);
		return EncryptedTimeTable.fromJSON(parsedResJson);
	}

	Future<EncryptedTimeTable> getTimeTable(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableBasicApi.getTimeTable',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getTimeTable");
		final parsedResJson = jsonDecode(res);
		return EncryptedTimeTable.fromJSON(parsedResJson);
	}

	Future<List<EncryptedTimeTable>> getTimeTables(String sdkId, List<String> timeTableIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableBasicApi.getTimeTables',
			{
				"sdkId": sdkId,
				"timeTableIds": jsonEncode(timeTableIds.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getTimeTables");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedTimeTable.fromJSON(x1) ).toList();
	}
}