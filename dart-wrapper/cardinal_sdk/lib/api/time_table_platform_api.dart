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


class TimeTablePlatformApi {
	String _sdkId;
	TryAndRecoverTimeTablePlatformApi tryAndRecover;
	EncryptedTimeTablePlatformApi encrypted;
	TimeTablePlatformApi(
		this._sdkId
		) : tryAndRecover = TryAndRecoverTimeTablePlatformApi(_sdkId),
		encrypted = EncryptedTimeTablePlatformApi(_sdkId);

	Future<DecryptedTimeTable> createTimeTable(DecryptedTimeTable entity) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.createTimeTable(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedTimeTable> withEncryptionMetadata(DecryptedTimeTable? base, Patient? patient, { User? user, Map<String, AccessLevel> delegates = const {}, SecretIdUseOption secretId = SecretIdUseOption.UseAnySharedWithParent }) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.withEncryptionMetadata(
			_sdkId,
			base,
			patient,
			user,
			delegates,
			secretId,
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(TimeTable timeTable) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.getEncryptionKeysOf(
			_sdkId,
			timeTable,
		);
	}

	Future<bool> hasWriteAccess(TimeTable timeTable) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.hasWriteAccess(
			_sdkId,
			timeTable,
		);
	}

	Future<Set<String>> decryptPatientIdOf(TimeTable timeTable) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.decryptPatientIdOf(
			_sdkId,
			timeTable,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(TimeTable entity, Set<String> delegates) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<DecryptedTimeTable> decrypt(EncryptedTimeTable timeTable) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.decrypt(
			_sdkId,
			timeTable,
		);
	}

	Future<TimeTable> tryDecrypt(EncryptedTimeTable timeTable) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.tryDecrypt(
			_sdkId,
			timeTable,
		);
	}

	Future<List<String>> matchTimeTablesBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.matchTimeTablesBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchTimeTablesBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.matchTimeTablesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteTimeTableById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.deleteTimeTableById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteTimeTablesByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.deleteTimeTablesByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeTimeTableById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.purgeTimeTableById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteTimeTable(TimeTable timeTable) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.deleteTimeTable(
			_sdkId,
			timeTable,
		);
	}

	Future<List<DocIdentifier>> deleteTimeTables(List<TimeTable> timeTables) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.deleteTimeTables(
			_sdkId,
			timeTables,
		);
	}

	Future<void> purgeTimeTable(TimeTable timeTable) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.purgeTimeTable(
			_sdkId,
			timeTable,
		);
	}

	Future<DecryptedTimeTable> shareWith(String delegateId, DecryptedTimeTable timeTable, { TimeTableShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.shareWith(
			_sdkId,
			delegateId,
			timeTable,
			options,
		);
	}

	Future<DecryptedTimeTable> shareWithMany(DecryptedTimeTable timeTable, Map<String, TimeTableShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.shareWithMany(
			_sdkId,
			timeTable,
			delegates,
		);
	}

	Future<PaginatedListIterator<DecryptedTimeTable>> filterTimeTablesBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.filterTimeTablesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<DecryptedTimeTable>> filterTimeTablesBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.filterTimeTablesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<TimeTable> undeleteTimeTable(TimeTable timeTable) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.undeleteTimeTable(
			_sdkId,
			timeTable,
		);
	}

	Future<DecryptedTimeTable> modifyTimeTable(DecryptedTimeTable entity) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.modifyTimeTable(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedTimeTable> undeleteTimeTableById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.undeleteTimeTableById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DecryptedTimeTable> getTimeTable(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.getTimeTable(
			_sdkId,
			entityId,
		);
	}

	Future<List<DecryptedTimeTable>> getTimeTables(List<String> timeTableIds) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.getTimeTables(
			_sdkId,
			timeTableIds,
		);
	}
}

class TryAndRecoverTimeTablePlatformApi {
	String _sdkId;
	TryAndRecoverTimeTablePlatformApi(this._sdkId);

	Future<TimeTable> shareWith(String delegateId, TimeTable timeTable, { TimeTableShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.tryAndRecover.shareWith(
			_sdkId,
			delegateId,
			timeTable,
			options,
		);
	}

	Future<TimeTable> shareWithMany(TimeTable timeTable, Map<String, TimeTableShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.tryAndRecover.shareWithMany(
			_sdkId,
			timeTable,
			delegates,
		);
	}

	Future<PaginatedListIterator<TimeTable>> filterTimeTablesBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.tryAndRecover.filterTimeTablesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<TimeTable>> filterTimeTablesBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.tryAndRecover.filterTimeTablesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<TimeTable> undeleteTimeTable(TimeTable timeTable) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.tryAndRecover.undeleteTimeTable(
			_sdkId,
			timeTable,
		);
	}

	Future<TimeTable> modifyTimeTable(TimeTable entity) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.tryAndRecover.modifyTimeTable(
			_sdkId,
			entity,
		);
	}

	Future<TimeTable> undeleteTimeTableById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.tryAndRecover.undeleteTimeTableById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<TimeTable> getTimeTable(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.tryAndRecover.getTimeTable(
			_sdkId,
			entityId,
		);
	}

	Future<List<TimeTable>> getTimeTables(List<String> timeTableIds) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.tryAndRecover.getTimeTables(
			_sdkId,
			timeTableIds,
		);
	}
}

class EncryptedTimeTablePlatformApi {
	String _sdkId;
	EncryptedTimeTablePlatformApi(this._sdkId);

	Future<EncryptedTimeTable> shareWith(String delegateId, EncryptedTimeTable timeTable, { TimeTableShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.encrypted.shareWith(
			_sdkId,
			delegateId,
			timeTable,
			options,
		);
	}

	Future<EncryptedTimeTable> shareWithMany(EncryptedTimeTable timeTable, Map<String, TimeTableShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.encrypted.shareWithMany(
			_sdkId,
			timeTable,
			delegates,
		);
	}

	Future<PaginatedListIterator<EncryptedTimeTable>> filterTimeTablesBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.encrypted.filterTimeTablesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedTimeTable>> filterTimeTablesBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.encrypted.filterTimeTablesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<TimeTable> undeleteTimeTable(TimeTable timeTable) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.encrypted.undeleteTimeTable(
			_sdkId,
			timeTable,
		);
	}

	Future<EncryptedTimeTable> modifyTimeTable(EncryptedTimeTable entity) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.encrypted.modifyTimeTable(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedTimeTable> undeleteTimeTableById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.encrypted.undeleteTimeTableById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedTimeTable> getTimeTable(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.encrypted.getTimeTable(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedTimeTable>> getTimeTables(List<String> timeTableIds) async {
		return await CardinalSdkPlatformInterface.instance.timeTable.encrypted.getTimeTables(
			_sdkId,
			timeTableIds,
		);
	}
}