// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/model/time_table.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';


class TimeTablePlatformApi {
	MethodChannel _methodChannel;
	TimeTablePlatformApi(this._methodChannel);

	Future<DocIdentifier> deleteTimeTableById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.deleteTimeTableById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteTimeTableById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteTimeTablesByIds(String sdkId, List<StoredDocumentIdentifier> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.deleteTimeTablesByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => StoredDocumentIdentifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteTimeTablesByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeTimeTableById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.purgeTimeTableById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
	}

	Future<DocIdentifier> deleteTimeTable(String sdkId, TimeTable timeTable) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.deleteTimeTable',
			{
				"sdkId": sdkId,
				"timeTable": jsonEncode(TimeTable.encode(timeTable)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteTimeTable");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteTimeTables(String sdkId, List<TimeTable> timeTables) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.deleteTimeTables',
			{
				"sdkId": sdkId,
				"timeTables": jsonEncode(timeTables.map((x0) => TimeTable.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteTimeTables");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeTimeTable(String sdkId, TimeTable timeTable) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.purgeTimeTable',
			{
				"sdkId": sdkId,
				"timeTable": jsonEncode(TimeTable.encode(timeTable)),
			}
		).catchError(convertPlatformException);
	}

	Future<TimeTable> undeleteTimeTable(String sdkId, TimeTable timeTable) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.undeleteTimeTable',
			{
				"sdkId": sdkId,
				"timeTable": jsonEncode(TimeTable.encode(timeTable)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteTimeTable");
		final parsedResJson = jsonDecode(res);
		return TimeTable.fromJSON(parsedResJson);
	}

	Future<TimeTable> modifyTimeTable(String sdkId, TimeTable entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.modifyTimeTable',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(TimeTable.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyTimeTable");
		final parsedResJson = jsonDecode(res);
		return TimeTable.fromJSON(parsedResJson);
	}

	Future<TimeTable> undeleteTimeTableById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.undeleteTimeTableById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteTimeTableById");
		final parsedResJson = jsonDecode(res);
		return TimeTable.fromJSON(parsedResJson);
	}

	Future<TimeTable?> getTimeTable(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.getTimeTable',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getTimeTable");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : TimeTable.fromJSON(parsedResJson);
	}

	Future<List<TimeTable>> getTimeTables(String sdkId, List<String> timeTableIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.getTimeTables',
			{
				"sdkId": sdkId,
				"timeTableIds": jsonEncode(timeTableIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getTimeTables");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => TimeTable.fromJSON(x1) ).toList();
	}

	Future<PaginatedListIterator<TimeTable>> filterTimeTablesBy(String sdkId, BaseFilterOptions<TimeTable> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.filterTimeTablesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterTimeTablesBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => TimeTable.fromJSON(x0));
	}

	Future<PaginatedListIterator<TimeTable>> filterTimeTablesBySorted(String sdkId, BaseSortableFilterOptions<TimeTable> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.filterTimeTablesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterTimeTablesBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => TimeTable.fromJSON(x0));
	}

	Future<TimeTable> createTimeTable(String sdkId, TimeTable entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.createTimeTable',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(TimeTable.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createTimeTable");
		final parsedResJson = jsonDecode(res);
		return TimeTable.fromJSON(parsedResJson);
	}

	Future<List<String>> matchTimeTablesBy(String sdkId, BaseFilterOptions<TimeTable> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.matchTimeTablesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchTimeTablesBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchTimeTablesBySorted(String sdkId, BaseSortableFilterOptions<TimeTable> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.matchTimeTablesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchTimeTablesBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}
}