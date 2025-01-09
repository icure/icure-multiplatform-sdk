// auto-generated file
import 'package:cardinal_sdk/model/time_table.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
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


class TimeTableApi {
	final String _sdkId;
	final Object _dartSdk;
	final TryAndRecoverTimeTableApi tryAndRecover;
	final EncryptedTimeTableApi encrypted;
	TimeTableApi(
		this._sdkId,
		this._dartSdk
		) : tryAndRecover = TryAndRecoverTimeTableApi(_sdkId, _dartSdk),
		encrypted = EncryptedTimeTableApi(_sdkId, _dartSdk);

	Future<DecryptedTimeTable> createTimeTable(DecryptedTimeTable entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.createTimeTable(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedTimeTable> withEncryptionMetadata(DecryptedTimeTable? base, Patient? patient, { User? user, Map<String, AccessLevel> delegates = const {}, SecretIdUseOption secretId = SecretIdUseOption.UseAnySharedWithParent }) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.withEncryptionMetadata(
			_sdkId,
			base,
			patient,
			user,
			delegates,
			secretId,
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(TimeTable timeTable) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.getEncryptionKeysOf(
			_sdkId,
			timeTable,
		);
	}

	Future<bool> hasWriteAccess(TimeTable timeTable) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.hasWriteAccess(
			_sdkId,
			timeTable,
		);
	}

	Future<Set<String>> decryptPatientIdOf(TimeTable timeTable) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.decryptPatientIdOf(
			_sdkId,
			timeTable,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(TimeTable entity, Set<String> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<DecryptedTimeTable> decrypt(EncryptedTimeTable timeTable) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.decrypt(
			_sdkId,
			timeTable,
		);
	}

	Future<TimeTable> tryDecrypt(EncryptedTimeTable timeTable) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.tryDecrypt(
			_sdkId,
			timeTable,
		);
	}

	Future<List<String>> matchTimeTablesBy(FilterOptions<TimeTable> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.matchTimeTablesBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchTimeTablesBySorted(SortableFilterOptions<TimeTable> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.matchTimeTablesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteTimeTableById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.deleteTimeTableById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteTimeTablesByIds(List<IdWithMandatoryRev> entityIds) async {
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

	Future<DecryptedTimeTable> shareWith(String delegateId, DecryptedTimeTable timeTable, { TimeTableShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.shareWith(
			_sdkId,
			delegateId,
			timeTable,
			options,
		);
	}

	Future<DecryptedTimeTable> shareWithMany(DecryptedTimeTable timeTable, Map<String, TimeTableShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.shareWithMany(
			_sdkId,
			timeTable,
			delegates,
		);
	}

	Future<PaginatedListIterator<DecryptedTimeTable>> filterTimeTablesBy(FilterOptions<TimeTable> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.filterTimeTablesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<DecryptedTimeTable>> filterTimeTablesBySorted(SortableFilterOptions<TimeTable> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.filterTimeTablesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<TimeTable> undeleteTimeTable(TimeTable timeTable) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.undeleteTimeTable(
			_sdkId,
			timeTable,
		);
	}

	Future<DecryptedTimeTable> modifyTimeTable(DecryptedTimeTable entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.modifyTimeTable(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedTimeTable> undeleteTimeTableById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.undeleteTimeTableById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DecryptedTimeTable> getTimeTable(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.getTimeTable(
			_sdkId,
			entityId,
		);
	}

	Future<List<DecryptedTimeTable>> getTimeTables(List<String> timeTableIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.getTimeTables(
			_sdkId,
			timeTableIds,
		);
	}
}

class TryAndRecoverTimeTableApi {
	final String _sdkId;
	final Object _dartSdk;
	TryAndRecoverTimeTableApi(
		this._sdkId,
		this._dartSdk
		);

	Future<TimeTable> shareWith(String delegateId, TimeTable timeTable, { TimeTableShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.tryAndRecover.shareWith(
			_sdkId,
			delegateId,
			timeTable,
			options,
		);
	}

	Future<TimeTable> shareWithMany(TimeTable timeTable, Map<String, TimeTableShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.tryAndRecover.shareWithMany(
			_sdkId,
			timeTable,
			delegates,
		);
	}

	Future<PaginatedListIterator<TimeTable>> filterTimeTablesBy(FilterOptions<TimeTable> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.tryAndRecover.filterTimeTablesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<TimeTable>> filterTimeTablesBySorted(SortableFilterOptions<TimeTable> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.tryAndRecover.filterTimeTablesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<TimeTable> undeleteTimeTable(TimeTable timeTable) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.tryAndRecover.undeleteTimeTable(
			_sdkId,
			timeTable,
		);
	}

	Future<TimeTable> modifyTimeTable(TimeTable entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.tryAndRecover.modifyTimeTable(
			_sdkId,
			entity,
		);
	}

	Future<TimeTable> undeleteTimeTableById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.tryAndRecover.undeleteTimeTableById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<TimeTable> getTimeTable(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.tryAndRecover.getTimeTable(
			_sdkId,
			entityId,
		);
	}

	Future<List<TimeTable>> getTimeTables(List<String> timeTableIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.tryAndRecover.getTimeTables(
			_sdkId,
			timeTableIds,
		);
	}
}

class EncryptedTimeTableApi {
	final String _sdkId;
	final Object _dartSdk;
	EncryptedTimeTableApi(
		this._sdkId,
		this._dartSdk
		);

	Future<EncryptedTimeTable> shareWith(String delegateId, EncryptedTimeTable timeTable, { TimeTableShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.encrypted.shareWith(
			_sdkId,
			delegateId,
			timeTable,
			options,
		);
	}

	Future<EncryptedTimeTable> shareWithMany(EncryptedTimeTable timeTable, Map<String, TimeTableShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.encrypted.shareWithMany(
			_sdkId,
			timeTable,
			delegates,
		);
	}

	Future<PaginatedListIterator<EncryptedTimeTable>> filterTimeTablesBy(FilterOptions<TimeTable> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.encrypted.filterTimeTablesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedTimeTable>> filterTimeTablesBySorted(SortableFilterOptions<TimeTable> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.encrypted.filterTimeTablesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<TimeTable> undeleteTimeTable(TimeTable timeTable) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.encrypted.undeleteTimeTable(
			_sdkId,
			timeTable,
		);
	}

	Future<EncryptedTimeTable> modifyTimeTable(EncryptedTimeTable entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.encrypted.modifyTimeTable(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedTimeTable> undeleteTimeTableById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.encrypted.undeleteTimeTableById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedTimeTable> getTimeTable(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.encrypted.getTimeTable(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedTimeTable>> getTimeTables(List<String> timeTableIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.timeTable.encrypted.getTimeTables(
			_sdkId,
			timeTableIds,
		);
	}
}