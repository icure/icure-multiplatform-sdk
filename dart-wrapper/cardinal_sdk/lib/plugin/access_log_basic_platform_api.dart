// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/access_log.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';


class AccessLogBasicPlatformApi {
	MethodChannel _methodChannel;
	AccessLogBasicPlatformApi(this._methodChannel);

	Future<List<String>> matchAccessLogsBy(String sdkId, BaseFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.matchAccessLogsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchAccessLogsBy");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<List<String>> matchAccessLogsBySorted(String sdkId, BaseSortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.matchAccessLogsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchAccessLogsBySorted");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<PaginatedListIterator<EncryptedAccessLog>> filterAccessLogsBy(String sdkId, BaseFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.filterAccessLogsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterAccessLogsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedAccessLog.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedAccessLog>> filterAccessLogsBySorted(String sdkId, BaseSortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.filterAccessLogsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterAccessLogsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedAccessLog.fromJSON(x0));
	}

	Future<DocIdentifier> deleteAccessLogById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.deleteAccessLogById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteAccessLogById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteAccessLogsByIds(String sdkId, List<IdWithMandatoryRev> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.deleteAccessLogsByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => IdWithMandatoryRev.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteAccessLogsByIds");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DocIdentifier.fromJSON(x1) );
	}

	Future<void> purgeAccessLogById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.purgeAccessLogById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
	}

	Future<DocIdentifier> deleteAccessLog(String sdkId, AccessLog accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.deleteAccessLog',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(AccessLog.encode(accessLog)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteAccessLog");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteAccessLogs(String sdkId, List<AccessLog> accessLogs) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.deleteAccessLogs',
			{
				"sdkId": sdkId,
				"accessLogs": jsonEncode(accessLogs.map((x0) => AccessLog.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteAccessLogs");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DocIdentifier.fromJSON(x1) );
	}

	Future<void> purgeAccessLog(String sdkId, AccessLog accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.purgeAccessLog',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(AccessLog.encode(accessLog)),
			}
		);
	}

	Future<EncryptedAccessLog> undeleteAccessLogById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.undeleteAccessLogById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteAccessLogById");
		final parsedResJson = jsonDecode(res);
		return EncryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<EncryptedAccessLog> undeleteAccessLog(String sdkId, AccessLog accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.undeleteAccessLog',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(AccessLog.encode(accessLog)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteAccessLog");
		final parsedResJson = jsonDecode(res);
		return EncryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<EncryptedAccessLog> modifyAccessLog(String sdkId, EncryptedAccessLog entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.modifyAccessLog',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedAccessLog.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyAccessLog");
		final parsedResJson = jsonDecode(res);
		return EncryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<EncryptedAccessLog> getAccessLog(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.getAccessLog',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getAccessLog");
		final parsedResJson = jsonDecode(res);
		return EncryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<List<EncryptedAccessLog>> getAccessLogs(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.getAccessLogs',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getAccessLogs");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedAccessLog.fromJSON(x1) );
	}
}