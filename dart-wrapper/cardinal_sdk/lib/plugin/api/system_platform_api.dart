// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/indexing_info.dart';
import 'package:cardinal_sdk/model/replication_info.dart';
import 'package:cardinal_sdk/model/id_with_rev.dart';
import 'package:cardinal_sdk/model/couchdb/replicator_document.dart';


class SystemPlatformApi {
	MethodChannel _methodChannel;
	SystemPlatformApi(this._methodChannel);

	Future<String> getVersion(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'SystemApi.getVersion',
			{
				"sdkId": sdkId,
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getVersion");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as String);
	}

	Future<String> isReady(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'SystemApi.isReady',
			{
				"sdkId": sdkId,
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method isReady");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as String);
	}

	Future<String> getProcessInfo(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'SystemApi.getProcessInfo',
			{
				"sdkId": sdkId,
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getProcessInfo");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as String);
	}

	Future<IndexingInfo> getIndexingInfo(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'SystemApi.getIndexingInfo',
			{
				"sdkId": sdkId,
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getIndexingInfo");
		final parsedResJson = jsonDecode(res);
		return IndexingInfo.fromJSON(parsedResJson);
	}

	Future<ReplicationInfo> getReplicationInfo(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'SystemApi.getReplicationInfo',
			{
				"sdkId": sdkId,
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getReplicationInfo");
		final parsedResJson = jsonDecode(res);
		return ReplicationInfo.fromJSON(parsedResJson);
	}

	Future<bool> updateDesignDoc(String sdkId, String entityName, bool? warmup) async {
		final res = await _methodChannel.invokeMethod<String>(
			'SystemApi.updateDesignDoc',
			{
				"sdkId": sdkId,
				"entityName": jsonEncode(entityName),
				"warmup": jsonEncode(warmup),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method updateDesignDoc");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as bool);
	}

	Future<List<IdWithRev>> resolvePatientsConflicts(String sdkId, int? limit) async {
		final res = await _methodChannel.invokeMethod<String>(
			'SystemApi.resolvePatientsConflicts',
			{
				"sdkId": sdkId,
				"limit": jsonEncode(limit),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method resolvePatientsConflicts");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => IdWithRev.fromJSON(x1) ).toList();
	}

	Future<List<IdWithRev>> resolveContactsConflicts(String sdkId, int? limit) async {
		final res = await _methodChannel.invokeMethod<String>(
			'SystemApi.resolveContactsConflicts',
			{
				"sdkId": sdkId,
				"limit": jsonEncode(limit),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method resolveContactsConflicts");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => IdWithRev.fromJSON(x1) ).toList();
	}

	Future<List<IdWithRev>> resolveFormsConflicts(String sdkId, int? limit) async {
		final res = await _methodChannel.invokeMethod<String>(
			'SystemApi.resolveFormsConflicts',
			{
				"sdkId": sdkId,
				"limit": jsonEncode(limit),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method resolveFormsConflicts");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => IdWithRev.fromJSON(x1) ).toList();
	}

	Future<List<IdWithRev>> resolveHealthElementsConflicts(String sdkId, int? limit) async {
		final res = await _methodChannel.invokeMethod<String>(
			'SystemApi.resolveHealthElementsConflicts',
			{
				"sdkId": sdkId,
				"limit": jsonEncode(limit),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method resolveHealthElementsConflicts");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => IdWithRev.fromJSON(x1) ).toList();
	}

	Future<List<IdWithRev>> resolveInvoicesConflicts(String sdkId, int? limit) async {
		final res = await _methodChannel.invokeMethod<String>(
			'SystemApi.resolveInvoicesConflicts',
			{
				"sdkId": sdkId,
				"limit": jsonEncode(limit),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method resolveInvoicesConflicts");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => IdWithRev.fromJSON(x1) ).toList();
	}

	Future<List<IdWithRev>> resolveMessagesConflicts(String sdkId, int? limit) async {
		final res = await _methodChannel.invokeMethod<String>(
			'SystemApi.resolveMessagesConflicts',
			{
				"sdkId": sdkId,
				"limit": jsonEncode(limit),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method resolveMessagesConflicts");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => IdWithRev.fromJSON(x1) ).toList();
	}

	Future<List<IdWithRev>> resolveDocumentsConflicts(String sdkId, String? ids, int? limit) async {
		final res = await _methodChannel.invokeMethod<String>(
			'SystemApi.resolveDocumentsConflicts',
			{
				"sdkId": sdkId,
				"ids": jsonEncode(ids),
				"limit": jsonEncode(limit),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method resolveDocumentsConflicts");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => IdWithRev.fromJSON(x1) ).toList();
	}

	Future<IndexingInfo> getIndexingInfoByGroup(String sdkId, String groupId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'SystemApi.getIndexingInfoByGroup',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getIndexingInfoByGroup");
		final parsedResJson = jsonDecode(res);
		return IndexingInfo.fromJSON(parsedResJson);
	}

	Future<ReplicatorDocument> getReplicatorInfo(String sdkId, String id) async {
		final res = await _methodChannel.invokeMethod<String>(
			'SystemApi.getReplicatorInfo',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getReplicatorInfo");
		final parsedResJson = jsonDecode(res);
		return ReplicatorDocument.fromJSON(parsedResJson);
	}

	Future<String> evictAllFromMap(String sdkId, String mapName) async {
		final res = await _methodChannel.invokeMethod<String>(
			'SystemApi.evictAllFromMap',
			{
				"sdkId": sdkId,
				"mapName": jsonEncode(mapName),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method evictAllFromMap");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as String);
	}
}