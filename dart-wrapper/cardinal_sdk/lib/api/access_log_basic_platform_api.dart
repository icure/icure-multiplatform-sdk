// auto-generated file
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/access_log.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';


class AccessLogBasicPlatformApi {
	String _sdkId;
	AccessLogBasicPlatformApi(this._sdkId);

	Future<List<String>> matchAccessLogsBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.accessLogBasic.matchAccessLogsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchAccessLogsBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.accessLogBasic.matchAccessLogsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedAccessLog>> filterAccessLogsBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.accessLogBasic.filterAccessLogsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedAccessLog>> filterAccessLogsBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.accessLogBasic.filterAccessLogsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteAccessLogById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.accessLogBasic.deleteAccessLogById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteAccessLogsByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.accessLogBasic.deleteAccessLogsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeAccessLogById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.accessLogBasic.purgeAccessLogById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteAccessLog(AccessLog accessLog) async {
		return await CardinalSdkPlatformInterface.instance.accessLogBasic.deleteAccessLog(
			_sdkId,
			accessLog,
		);
	}

	Future<List<DocIdentifier>> deleteAccessLogs(List<AccessLog> accessLogs) async {
		return await CardinalSdkPlatformInterface.instance.accessLogBasic.deleteAccessLogs(
			_sdkId,
			accessLogs,
		);
	}

	Future<void> purgeAccessLog(AccessLog accessLog) async {
		return await CardinalSdkPlatformInterface.instance.accessLogBasic.purgeAccessLog(
			_sdkId,
			accessLog,
		);
	}

	Future<EncryptedAccessLog> undeleteAccessLogById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.accessLogBasic.undeleteAccessLogById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedAccessLog> undeleteAccessLog(AccessLog accessLog) async {
		return await CardinalSdkPlatformInterface.instance.accessLogBasic.undeleteAccessLog(
			_sdkId,
			accessLog,
		);
	}

	Future<EncryptedAccessLog> modifyAccessLog(EncryptedAccessLog entity) async {
		return await CardinalSdkPlatformInterface.instance.accessLogBasic.modifyAccessLog(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedAccessLog> getAccessLog(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.accessLogBasic.getAccessLog(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedAccessLog>> getAccessLogs(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.accessLogBasic.getAccessLogs(
			_sdkId,
			entityIds,
		);
	}
}