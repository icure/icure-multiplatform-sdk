// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/access_log.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/crypto/entities/access_log_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';


class AccessLogPlatformApi {
	MethodChannel _methodChannel;
	TryAndRecoverAccessLogPlatformApi tryAndRecover;
	EncryptedAccessLogPlatformApi encrypted;
	AccessLogPlatformApi(
		this._methodChannel
		) : tryAndRecover = TryAndRecoverAccessLogPlatformApi(_methodChannel),
		encrypted = EncryptedAccessLogPlatformApi(_methodChannel);

	Future<DecryptedAccessLog> createAccessLog(String sdkId, DecryptedAccessLog entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.createAccessLog',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedAccessLog.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createAccessLog");
		final parsedResJson = jsonDecode(res);
		return DecryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<DecryptedAccessLog> withEncryptionMetadata(String sdkId, DecryptedAccessLog? base, Patient patient, User? user, Map<String, AccessLevel> delegates, SecretIdUseOption secretId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.withEncryptionMetadata',
			{
				"sdkId": sdkId,
				"base": jsonEncode(base == null ? null : DecryptedAccessLog.encode(base!)),
				"patient": jsonEncode(Patient.encode(patient)),
				"user": jsonEncode(user == null ? null : User.encode(user!)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLevel.encode(v0)))),
				"secretId": jsonEncode(SecretIdUseOption.encode(secretId)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method withEncryptionMetadata");
		final parsedResJson = jsonDecode(res);
		return DecryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<Set<HexString>> getEncryptionKeysOf(String sdkId, AccessLog accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.getEncryptionKeysOf',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(AccessLog.encode(accessLog)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getEncryptionKeysOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as HexString) ).toSet();
	}

	Future<bool> hasWriteAccess(String sdkId, AccessLog accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.hasWriteAccess',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(AccessLog.encode(accessLog)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method hasWriteAccess");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as bool);
	}

	Future<Set<String>> decryptPatientIdOf(String sdkId, AccessLog accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.decryptPatientIdOf',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(AccessLog.encode(accessLog)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method decryptPatientIdOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toSet();
	}

	Future<void> createDelegationDeAnonymizationMetadata(String sdkId, AccessLog entity, Set<String> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.createDelegationDeAnonymizationMetadata',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(AccessLog.encode(entity)),
				"delegates": jsonEncode(delegates.map((x0) => x0).toList()),
			}
		);
	}

	Future<DecryptedAccessLog> decrypt(String sdkId, EncryptedAccessLog accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.decrypt',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(EncryptedAccessLog.encode(accessLog)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method decrypt");
		final parsedResJson = jsonDecode(res);
		return DecryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<AccessLog> tryDecrypt(String sdkId, EncryptedAccessLog accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.tryDecrypt',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(EncryptedAccessLog.encode(accessLog)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method tryDecrypt");
		final parsedResJson = jsonDecode(res);
		return AccessLog.fromJSON(parsedResJson);
	}

	Future<List<String>> matchAccessLogsBy(String sdkId, FilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.matchAccessLogsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchAccessLogsBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchAccessLogsBySorted(String sdkId, SortableFilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.matchAccessLogsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchAccessLogsBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<DocIdentifier> deleteAccessLogById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.deleteAccessLogById',
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
			'AccessLogApi.deleteAccessLogsByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => IdWithMandatoryRev.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteAccessLogsByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeAccessLogById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.purgeAccessLogById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
	}

	Future<DocIdentifier> deleteAccessLog(String sdkId, AccessLog accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.deleteAccessLog',
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
			'AccessLogApi.deleteAccessLogs',
			{
				"sdkId": sdkId,
				"accessLogs": jsonEncode(accessLogs.map((x0) => AccessLog.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteAccessLogs");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeAccessLog(String sdkId, AccessLog accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.purgeAccessLog',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(AccessLog.encode(accessLog)),
			}
		);
	}

	Future<DecryptedAccessLog> shareWith(String sdkId, String delegateId, DecryptedAccessLog accessLog, AccessLogShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"accessLog": jsonEncode(DecryptedAccessLog.encode(accessLog)),
				"options": jsonEncode(options == null ? null : AccessLogShareOptions.encode(options!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return DecryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<DecryptedAccessLog> shareWithMany(String sdkId, DecryptedAccessLog accessLog, Map<String, AccessLogShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.shareWithMany',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(DecryptedAccessLog.encode(accessLog)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLogShareOptions.encode(v0)))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return DecryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<DecryptedAccessLog>> filterAccessLogsBy(String sdkId, FilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.filterAccessLogsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterAccessLogsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedAccessLog.fromJSON(x0));
	}

	Future<PaginatedListIterator<DecryptedAccessLog>> filterAccessLogsBySorted(String sdkId, SortableFilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.filterAccessLogsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterAccessLogsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedAccessLog.fromJSON(x0));
	}

	Future<DecryptedAccessLog> undeleteAccessLogById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.undeleteAccessLogById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteAccessLogById");
		final parsedResJson = jsonDecode(res);
		return DecryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<DecryptedAccessLog> undeleteAccessLog(String sdkId, AccessLog accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.undeleteAccessLog',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(AccessLog.encode(accessLog)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteAccessLog");
		final parsedResJson = jsonDecode(res);
		return DecryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<DecryptedAccessLog> modifyAccessLog(String sdkId, DecryptedAccessLog entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.modifyAccessLog',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedAccessLog.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyAccessLog");
		final parsedResJson = jsonDecode(res);
		return DecryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<DecryptedAccessLog> getAccessLog(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.getAccessLog',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getAccessLog");
		final parsedResJson = jsonDecode(res);
		return DecryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<List<DecryptedAccessLog>> getAccessLogs(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.getAccessLogs',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getAccessLogs");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedAccessLog.fromJSON(x1) ).toList();
	}
}

class TryAndRecoverAccessLogPlatformApi {
	MethodChannel _methodChannel;
	TryAndRecoverAccessLogPlatformApi(this._methodChannel);

	Future<AccessLog> shareWith(String sdkId, String delegateId, AccessLog accessLog, AccessLogShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.tryAndRecover.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"accessLog": jsonEncode(AccessLog.encode(accessLog)),
				"options": jsonEncode(options == null ? null : AccessLogShareOptions.encode(options!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return AccessLog.fromJSON(parsedResJson);
	}

	Future<AccessLog> shareWithMany(String sdkId, AccessLog accessLog, Map<String, AccessLogShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.tryAndRecover.shareWithMany',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(AccessLog.encode(accessLog)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLogShareOptions.encode(v0)))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return AccessLog.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<AccessLog>> filterAccessLogsBy(String sdkId, FilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.tryAndRecover.filterAccessLogsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterAccessLogsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => AccessLog.fromJSON(x0));
	}

	Future<PaginatedListIterator<AccessLog>> filterAccessLogsBySorted(String sdkId, SortableFilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.tryAndRecover.filterAccessLogsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterAccessLogsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => AccessLog.fromJSON(x0));
	}

	Future<AccessLog> undeleteAccessLogById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.tryAndRecover.undeleteAccessLogById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteAccessLogById");
		final parsedResJson = jsonDecode(res);
		return AccessLog.fromJSON(parsedResJson);
	}

	Future<AccessLog> undeleteAccessLog(String sdkId, AccessLog accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.tryAndRecover.undeleteAccessLog',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(AccessLog.encode(accessLog)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteAccessLog");
		final parsedResJson = jsonDecode(res);
		return AccessLog.fromJSON(parsedResJson);
	}

	Future<AccessLog> modifyAccessLog(String sdkId, AccessLog entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.tryAndRecover.modifyAccessLog',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(AccessLog.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyAccessLog");
		final parsedResJson = jsonDecode(res);
		return AccessLog.fromJSON(parsedResJson);
	}

	Future<AccessLog> getAccessLog(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.tryAndRecover.getAccessLog',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getAccessLog");
		final parsedResJson = jsonDecode(res);
		return AccessLog.fromJSON(parsedResJson);
	}

	Future<List<AccessLog>> getAccessLogs(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.tryAndRecover.getAccessLogs',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getAccessLogs");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => AccessLog.fromJSON(x1) ).toList();
	}
}

class EncryptedAccessLogPlatformApi {
	MethodChannel _methodChannel;
	EncryptedAccessLogPlatformApi(this._methodChannel);

	Future<EncryptedAccessLog> shareWith(String sdkId, String delegateId, EncryptedAccessLog accessLog, AccessLogShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.encrypted.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"accessLog": jsonEncode(EncryptedAccessLog.encode(accessLog)),
				"options": jsonEncode(options == null ? null : AccessLogShareOptions.encode(options!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return EncryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<EncryptedAccessLog> shareWithMany(String sdkId, EncryptedAccessLog accessLog, Map<String, AccessLogShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.encrypted.shareWithMany',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(EncryptedAccessLog.encode(accessLog)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLogShareOptions.encode(v0)))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return EncryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<EncryptedAccessLog>> filterAccessLogsBy(String sdkId, FilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.encrypted.filterAccessLogsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterAccessLogsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedAccessLog.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedAccessLog>> filterAccessLogsBySorted(String sdkId, SortableFilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.encrypted.filterAccessLogsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterAccessLogsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedAccessLog.fromJSON(x0));
	}

	Future<EncryptedAccessLog> undeleteAccessLogById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.encrypted.undeleteAccessLogById',
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
			'AccessLogApi.encrypted.undeleteAccessLog',
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
			'AccessLogApi.encrypted.modifyAccessLog',
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
			'AccessLogApi.encrypted.getAccessLog',
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
			'AccessLogApi.encrypted.getAccessLogs',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getAccessLogs");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedAccessLog.fromJSON(x1) ).toList();
	}
}