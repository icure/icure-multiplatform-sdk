// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/time_table.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/crypto/entities/time_table_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';


class TimeTablePlatformApi {
	MethodChannel _methodChannel;
	TryAndRecoverTimeTablePlatformApi tryAndRecover;
	EncryptedTimeTablePlatformApi encrypted;
	TimeTablePlatformApi(
		this._methodChannel
		) : tryAndRecover = TryAndRecoverTimeTablePlatformApi(_methodChannel),
		encrypted = EncryptedTimeTablePlatformApi(_methodChannel);

	Future<DecryptedTimeTable> createTimeTable(String sdkId, DecryptedTimeTable entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.createTimeTable',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedTimeTable.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createTimeTable");
		final parsedResJson = jsonDecode(res);
		return DecryptedTimeTable.fromJSON(parsedResJson);
	}

	Future<DecryptedTimeTable> withEncryptionMetadata(String sdkId, DecryptedTimeTable? base, Patient? patient, User? user, Map<String, AccessLevel> delegates, SecretIdUseOption secretId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.withEncryptionMetadata',
			{
				"sdkId": sdkId,
				"base": jsonEncode(base == null ? null : DecryptedTimeTable.encode(base!)),
				"patient": jsonEncode(patient == null ? null : Patient.encode(patient!)),
				"user": jsonEncode(user == null ? null : User.encode(user!)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLevel.encode(v0)))),
				"secretId": jsonEncode(SecretIdUseOption.encode(secretId)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method withEncryptionMetadata");
		final parsedResJson = jsonDecode(res);
		return DecryptedTimeTable.fromJSON(parsedResJson);
	}

	Future<Set<HexString>> getEncryptionKeysOf(String sdkId, TimeTable timeTable) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.getEncryptionKeysOf',
			{
				"sdkId": sdkId,
				"timeTable": jsonEncode(TimeTable.encode(timeTable)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getEncryptionKeysOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as HexString) ).toSet();
	}

	Future<bool> hasWriteAccess(String sdkId, TimeTable timeTable) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.hasWriteAccess',
			{
				"sdkId": sdkId,
				"timeTable": jsonEncode(TimeTable.encode(timeTable)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method hasWriteAccess");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as bool);
	}

	Future<Set<String>> decryptPatientIdOf(String sdkId, TimeTable timeTable) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.decryptPatientIdOf',
			{
				"sdkId": sdkId,
				"timeTable": jsonEncode(TimeTable.encode(timeTable)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method decryptPatientIdOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toSet();
	}

	Future<void> createDelegationDeAnonymizationMetadata(String sdkId, TimeTable entity, Set<String> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.createDelegationDeAnonymizationMetadata',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(TimeTable.encode(entity)),
				"delegates": jsonEncode(delegates.map((x0) => x0).toList()),
			}
		);
	}

	Future<DecryptedTimeTable> decrypt(String sdkId, EncryptedTimeTable timeTable) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.decrypt',
			{
				"sdkId": sdkId,
				"timeTable": jsonEncode(EncryptedTimeTable.encode(timeTable)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method decrypt");
		final parsedResJson = jsonDecode(res);
		return DecryptedTimeTable.fromJSON(parsedResJson);
	}

	Future<TimeTable> tryDecrypt(String sdkId, EncryptedTimeTable timeTable) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.tryDecrypt',
			{
				"sdkId": sdkId,
				"timeTable": jsonEncode(EncryptedTimeTable.encode(timeTable)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method tryDecrypt");
		final parsedResJson = jsonDecode(res);
		return TimeTable.fromJSON(parsedResJson);
	}

	Future<List<String>> matchTimeTablesBy(String sdkId, FilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.matchTimeTablesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchTimeTablesBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchTimeTablesBySorted(String sdkId, SortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.matchTimeTablesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchTimeTablesBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<DocIdentifier> deleteTimeTableById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.deleteTimeTableById',
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
			'TimeTableApi.deleteTimeTablesByIds',
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
			'TimeTableApi.purgeTimeTableById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
	}

	Future<DocIdentifier> deleteTimeTable(String sdkId, TimeTable timeTable) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.deleteTimeTable',
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
			'TimeTableApi.deleteTimeTables',
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
			'TimeTableApi.purgeTimeTable',
			{
				"sdkId": sdkId,
				"timeTable": jsonEncode(TimeTable.encode(timeTable)),
			}
		);
	}

	Future<DecryptedTimeTable> shareWith(String sdkId, String delegateId, DecryptedTimeTable timeTable, TimeTableShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"timeTable": jsonEncode(DecryptedTimeTable.encode(timeTable)),
				"options": jsonEncode(options == null ? null : TimeTableShareOptions.encode(options!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return DecryptedTimeTable.fromJSON(parsedResJson);
	}

	Future<DecryptedTimeTable> shareWithMany(String sdkId, DecryptedTimeTable timeTable, Map<String, TimeTableShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.shareWithMany',
			{
				"sdkId": sdkId,
				"timeTable": jsonEncode(DecryptedTimeTable.encode(timeTable)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, TimeTableShareOptions.encode(v0)))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return DecryptedTimeTable.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<DecryptedTimeTable>> filterTimeTablesBy(String sdkId, FilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.filterTimeTablesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterTimeTablesBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedTimeTable.fromJSON(x0));
	}

	Future<PaginatedListIterator<DecryptedTimeTable>> filterTimeTablesBySorted(String sdkId, SortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.filterTimeTablesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterTimeTablesBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedTimeTable.fromJSON(x0));
	}

	Future<TimeTable> undeleteTimeTable(String sdkId, TimeTable timeTable) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.undeleteTimeTable',
			{
				"sdkId": sdkId,
				"timeTable": jsonEncode(TimeTable.encode(timeTable)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteTimeTable");
		final parsedResJson = jsonDecode(res);
		return TimeTable.fromJSON(parsedResJson);
	}

	Future<DecryptedTimeTable> modifyTimeTable(String sdkId, DecryptedTimeTable entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.modifyTimeTable',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedTimeTable.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyTimeTable");
		final parsedResJson = jsonDecode(res);
		return DecryptedTimeTable.fromJSON(parsedResJson);
	}

	Future<DecryptedTimeTable> undeleteTimeTableById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.undeleteTimeTableById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteTimeTableById");
		final parsedResJson = jsonDecode(res);
		return DecryptedTimeTable.fromJSON(parsedResJson);
	}

	Future<DecryptedTimeTable> getTimeTable(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.getTimeTable',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getTimeTable");
		final parsedResJson = jsonDecode(res);
		return DecryptedTimeTable.fromJSON(parsedResJson);
	}

	Future<List<DecryptedTimeTable>> getTimeTables(String sdkId, List<String> timeTableIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.getTimeTables',
			{
				"sdkId": sdkId,
				"timeTableIds": jsonEncode(timeTableIds.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getTimeTables");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedTimeTable.fromJSON(x1) ).toList();
	}
}

class TryAndRecoverTimeTablePlatformApi {
	MethodChannel _methodChannel;
	TryAndRecoverTimeTablePlatformApi(this._methodChannel);

	Future<TimeTable> shareWith(String sdkId, String delegateId, TimeTable timeTable, TimeTableShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.tryAndRecover.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"timeTable": jsonEncode(TimeTable.encode(timeTable)),
				"options": jsonEncode(options == null ? null : TimeTableShareOptions.encode(options!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return TimeTable.fromJSON(parsedResJson);
	}

	Future<TimeTable> shareWithMany(String sdkId, TimeTable timeTable, Map<String, TimeTableShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.tryAndRecover.shareWithMany',
			{
				"sdkId": sdkId,
				"timeTable": jsonEncode(TimeTable.encode(timeTable)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, TimeTableShareOptions.encode(v0)))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return TimeTable.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<TimeTable>> filterTimeTablesBy(String sdkId, FilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.tryAndRecover.filterTimeTablesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterTimeTablesBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => TimeTable.fromJSON(x0));
	}

	Future<PaginatedListIterator<TimeTable>> filterTimeTablesBySorted(String sdkId, SortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.tryAndRecover.filterTimeTablesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterTimeTablesBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => TimeTable.fromJSON(x0));
	}

	Future<TimeTable> undeleteTimeTable(String sdkId, TimeTable timeTable) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.tryAndRecover.undeleteTimeTable',
			{
				"sdkId": sdkId,
				"timeTable": jsonEncode(TimeTable.encode(timeTable)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteTimeTable");
		final parsedResJson = jsonDecode(res);
		return TimeTable.fromJSON(parsedResJson);
	}

	Future<TimeTable> modifyTimeTable(String sdkId, TimeTable entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.tryAndRecover.modifyTimeTable',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(TimeTable.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyTimeTable");
		final parsedResJson = jsonDecode(res);
		return TimeTable.fromJSON(parsedResJson);
	}

	Future<TimeTable> undeleteTimeTableById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.tryAndRecover.undeleteTimeTableById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteTimeTableById");
		final parsedResJson = jsonDecode(res);
		return TimeTable.fromJSON(parsedResJson);
	}

	Future<TimeTable> getTimeTable(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.tryAndRecover.getTimeTable',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getTimeTable");
		final parsedResJson = jsonDecode(res);
		return TimeTable.fromJSON(parsedResJson);
	}

	Future<List<TimeTable>> getTimeTables(String sdkId, List<String> timeTableIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.tryAndRecover.getTimeTables',
			{
				"sdkId": sdkId,
				"timeTableIds": jsonEncode(timeTableIds.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getTimeTables");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => TimeTable.fromJSON(x1) ).toList();
	}
}

class EncryptedTimeTablePlatformApi {
	MethodChannel _methodChannel;
	EncryptedTimeTablePlatformApi(this._methodChannel);

	Future<EncryptedTimeTable> shareWith(String sdkId, String delegateId, EncryptedTimeTable timeTable, TimeTableShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.encrypted.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"timeTable": jsonEncode(EncryptedTimeTable.encode(timeTable)),
				"options": jsonEncode(options == null ? null : TimeTableShareOptions.encode(options!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return EncryptedTimeTable.fromJSON(parsedResJson);
	}

	Future<EncryptedTimeTable> shareWithMany(String sdkId, EncryptedTimeTable timeTable, Map<String, TimeTableShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.encrypted.shareWithMany',
			{
				"sdkId": sdkId,
				"timeTable": jsonEncode(EncryptedTimeTable.encode(timeTable)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, TimeTableShareOptions.encode(v0)))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return EncryptedTimeTable.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<EncryptedTimeTable>> filterTimeTablesBy(String sdkId, FilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.encrypted.filterTimeTablesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterTimeTablesBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedTimeTable.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedTimeTable>> filterTimeTablesBySorted(String sdkId, SortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.encrypted.filterTimeTablesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterTimeTablesBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedTimeTable.fromJSON(x0));
	}

	Future<TimeTable> undeleteTimeTable(String sdkId, TimeTable timeTable) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableApi.encrypted.undeleteTimeTable',
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
			'TimeTableApi.encrypted.modifyTimeTable',
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
			'TimeTableApi.encrypted.undeleteTimeTableById',
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
			'TimeTableApi.encrypted.getTimeTable',
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
			'TimeTableApi.encrypted.getTimeTables',
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