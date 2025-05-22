// auto-generated file
import 'package:cardinal_sdk/model/access_log.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/crypto/entities/access_log_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';


class AccessLogApi {
	final String _sdkId;
	final Object _dartSdk;
	final AccessLogEncryptedApi encrypted;
	final AccessLogTryAndRecoverApi tryAndRecover;
	AccessLogApi(
		this._sdkId,
		this._dartSdk
		) : encrypted = AccessLogEncryptedApi(_sdkId, _dartSdk),
		tryAndRecover = AccessLogTryAndRecoverApi(_sdkId, _dartSdk);

	Future<DecryptedAccessLog> withEncryptionMetadata(DecryptedAccessLog? base, Patient patient, { User? user, Map<String, AccessLevel> delegates = const {}, SecretIdUseOption secretId = SecretIdUseOption.UseAnySharedWithParent }) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.withEncryptionMetadata(
			_sdkId,
			base,
			patient,
			user,
			delegates,
			secretId,
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(AccessLog accessLog) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.getEncryptionKeysOf(
			_sdkId,
			accessLog,
		);
	}

	Future<bool> hasWriteAccess(AccessLog accessLog) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.hasWriteAccess(
			_sdkId,
			accessLog,
		);
	}

	Future<Set<String>> decryptPatientIdOf(AccessLog accessLog) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.decryptPatientIdOf(
			_sdkId,
			accessLog,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(AccessLog entity, Set<String> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<DecryptedAccessLog> decrypt(EncryptedAccessLog accessLog) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.decrypt(
			_sdkId,
			accessLog,
		);
	}

	Future<AccessLog> tryDecrypt(EncryptedAccessLog accessLog) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.tryDecrypt(
			_sdkId,
			accessLog,
		);
	}

	Future<List<String>> matchAccessLogsBy(FilterOptions<AccessLog> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.matchAccessLogsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchAccessLogsBySorted(SortableFilterOptions<AccessLog> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.matchAccessLogsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteAccessLogById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.deleteAccessLogById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteAccessLogsByIds(List<StoredDocumentIdentifier> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.deleteAccessLogsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeAccessLogById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.purgeAccessLogById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteAccessLog(AccessLog accessLog) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.deleteAccessLog(
			_sdkId,
			accessLog,
		);
	}

	Future<List<DocIdentifier>> deleteAccessLogs(List<AccessLog> accessLogs) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.deleteAccessLogs(
			_sdkId,
			accessLogs,
		);
	}

	Future<void> purgeAccessLog(AccessLog accessLog) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.purgeAccessLog(
			_sdkId,
			accessLog,
		);
	}

	Future<DecryptedAccessLog> shareWith(String delegateId, DecryptedAccessLog accessLog, { AccessLogShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.shareWith(
			_sdkId,
			delegateId,
			accessLog,
			options,
		);
	}

	Future<DecryptedAccessLog> shareWithMany(DecryptedAccessLog accessLog, Map<String, AccessLogShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.shareWithMany(
			_sdkId,
			accessLog,
			delegates,
		);
	}

	Future<PaginatedListIterator<DecryptedAccessLog>> filterAccessLogsBy(FilterOptions<AccessLog> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.filterAccessLogsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<DecryptedAccessLog>> filterAccessLogsBySorted(SortableFilterOptions<AccessLog> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.filterAccessLogsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DecryptedAccessLog> createAccessLog(DecryptedAccessLog entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.createAccessLog(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedAccessLog> undeleteAccessLogById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.undeleteAccessLogById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DecryptedAccessLog> undeleteAccessLog(AccessLog accessLog) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.undeleteAccessLog(
			_sdkId,
			accessLog,
		);
	}

	Future<DecryptedAccessLog> modifyAccessLog(DecryptedAccessLog entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.modifyAccessLog(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedAccessLog?> getAccessLog(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.getAccessLog(
			_sdkId,
			entityId,
		);
	}

	Future<List<DecryptedAccessLog>> getAccessLogs(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.getAccessLogs(
			_sdkId,
			entityIds,
		);
	}
}

class AccessLogTryAndRecoverApi {
	final String _sdkId;
	final Object _dartSdk;
	AccessLogTryAndRecoverApi(
		this._sdkId,
		this._dartSdk
		);

	Future<AccessLog> shareWith(String delegateId, AccessLog accessLog, { AccessLogShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.tryAndRecover.shareWith(
			_sdkId,
			delegateId,
			accessLog,
			options,
		);
	}

	Future<AccessLog> shareWithMany(AccessLog accessLog, Map<String, AccessLogShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.tryAndRecover.shareWithMany(
			_sdkId,
			accessLog,
			delegates,
		);
	}

	Future<PaginatedListIterator<AccessLog>> filterAccessLogsBy(FilterOptions<AccessLog> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.tryAndRecover.filterAccessLogsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<AccessLog>> filterAccessLogsBySorted(SortableFilterOptions<AccessLog> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.tryAndRecover.filterAccessLogsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<AccessLog> createAccessLog(AccessLog entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.tryAndRecover.createAccessLog(
			_sdkId,
			entity,
		);
	}

	Future<AccessLog> undeleteAccessLogById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.tryAndRecover.undeleteAccessLogById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<AccessLog> undeleteAccessLog(AccessLog accessLog) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.tryAndRecover.undeleteAccessLog(
			_sdkId,
			accessLog,
		);
	}

	Future<AccessLog> modifyAccessLog(AccessLog entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.tryAndRecover.modifyAccessLog(
			_sdkId,
			entity,
		);
	}

	Future<AccessLog?> getAccessLog(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.tryAndRecover.getAccessLog(
			_sdkId,
			entityId,
		);
	}

	Future<List<AccessLog>> getAccessLogs(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.tryAndRecover.getAccessLogs(
			_sdkId,
			entityIds,
		);
	}
}

class AccessLogEncryptedApi {
	final String _sdkId;
	final Object _dartSdk;
	AccessLogEncryptedApi(
		this._sdkId,
		this._dartSdk
		);

	Future<EncryptedAccessLog> shareWith(String delegateId, EncryptedAccessLog accessLog, { AccessLogShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.encrypted.shareWith(
			_sdkId,
			delegateId,
			accessLog,
			options,
		);
	}

	Future<EncryptedAccessLog> shareWithMany(EncryptedAccessLog accessLog, Map<String, AccessLogShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.encrypted.shareWithMany(
			_sdkId,
			accessLog,
			delegates,
		);
	}

	Future<PaginatedListIterator<EncryptedAccessLog>> filterAccessLogsBy(FilterOptions<AccessLog> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.encrypted.filterAccessLogsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedAccessLog>> filterAccessLogsBySorted(SortableFilterOptions<AccessLog> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.encrypted.filterAccessLogsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<EncryptedAccessLog> createAccessLog(EncryptedAccessLog entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.encrypted.createAccessLog(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedAccessLog> undeleteAccessLogById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.encrypted.undeleteAccessLogById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedAccessLog> undeleteAccessLog(AccessLog accessLog) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.encrypted.undeleteAccessLog(
			_sdkId,
			accessLog,
		);
	}

	Future<EncryptedAccessLog> modifyAccessLog(EncryptedAccessLog entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.encrypted.modifyAccessLog(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedAccessLog?> getAccessLog(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.encrypted.getAccessLog(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedAccessLog>> getAccessLogs(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLog.encrypted.getAccessLogs(
			_sdkId,
			entityIds,
		);
	}
}