// auto-generated file
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/access_log.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';


class AccessLogBasicApi {
	final String _sdkId;
	AccessLogBasicApi(this._sdkId);

	Future<List<String>> matchAccessLogsBy(BaseFilterOptions<AccessLog> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.matchAccessLogsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchAccessLogsBySorted(BaseSortableFilterOptions<AccessLog> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.matchAccessLogsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedAccessLog>> filterAccessLogsBy(BaseFilterOptions<AccessLog> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.filterAccessLogsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedAccessLog>> filterAccessLogsBySorted(BaseSortableFilterOptions<AccessLog> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.filterAccessLogsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteAccessLogById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.deleteAccessLogById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteAccessLogsByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.deleteAccessLogsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeAccessLogById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.purgeAccessLogById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteAccessLog(AccessLog accessLog) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.deleteAccessLog(
			_sdkId,
			accessLog,
		);
	}

	Future<List<DocIdentifier>> deleteAccessLogs(List<AccessLog> accessLogs) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.deleteAccessLogs(
			_sdkId,
			accessLogs,
		);
	}

	Future<void> purgeAccessLog(AccessLog accessLog) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.purgeAccessLog(
			_sdkId,
			accessLog,
		);
	}

	Future<EncryptedAccessLog> undeleteAccessLogById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.undeleteAccessLogById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedAccessLog> undeleteAccessLog(AccessLog accessLog) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.undeleteAccessLog(
			_sdkId,
			accessLog,
		);
	}

	Future<EncryptedAccessLog> modifyAccessLog(EncryptedAccessLog entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.modifyAccessLog(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedAccessLog> getAccessLog(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.getAccessLog(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedAccessLog>> getAccessLogs(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.getAccessLogs(
			_sdkId,
			entityIds,
		);
	}
}