// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/indexing_info.dart';
import 'package:cardinal_sdk/model/replication_info.dart';
import 'package:cardinal_sdk/model/id_with_rev.dart';
import 'package:cardinal_sdk/model/couchdb/replicator_document.dart';


class SystemPlatformApi {
	String _sdkId;
	SystemPlatformApi(this._sdkId);

	Future<String> getVersion() async {
		return await CardinalSdkPlatformInterface.instance.system.getVersion(
			_sdkId,
		);
	}

	Future<String> isReady() async {
		return await CardinalSdkPlatformInterface.instance.system.isReady(
			_sdkId,
		);
	}

	Future<String> getProcessInfo() async {
		return await CardinalSdkPlatformInterface.instance.system.getProcessInfo(
			_sdkId,
		);
	}

	Future<IndexingInfo> getIndexingInfo() async {
		return await CardinalSdkPlatformInterface.instance.system.getIndexingInfo(
			_sdkId,
		);
	}

	Future<ReplicationInfo> getReplicationInfo() async {
		return await CardinalSdkPlatformInterface.instance.system.getReplicationInfo(
			_sdkId,
		);
	}

	Future<bool> updateDesignDoc(String entityName, bool? warmup) async {
		return await CardinalSdkPlatformInterface.instance.system.updateDesignDoc(
			_sdkId,
			entityName,
			warmup,
		);
	}

	Future<List<IdWithRev>> resolvePatientsConflicts(int? limit) async {
		return await CardinalSdkPlatformInterface.instance.system.resolvePatientsConflicts(
			_sdkId,
			limit,
		);
	}

	Future<List<IdWithRev>> resolveContactsConflicts(int? limit) async {
		return await CardinalSdkPlatformInterface.instance.system.resolveContactsConflicts(
			_sdkId,
			limit,
		);
	}

	Future<List<IdWithRev>> resolveFormsConflicts(int? limit) async {
		return await CardinalSdkPlatformInterface.instance.system.resolveFormsConflicts(
			_sdkId,
			limit,
		);
	}

	Future<List<IdWithRev>> resolveHealthElementsConflicts(int? limit) async {
		return await CardinalSdkPlatformInterface.instance.system.resolveHealthElementsConflicts(
			_sdkId,
			limit,
		);
	}

	Future<List<IdWithRev>> resolveInvoicesConflicts(int? limit) async {
		return await CardinalSdkPlatformInterface.instance.system.resolveInvoicesConflicts(
			_sdkId,
			limit,
		);
	}

	Future<List<IdWithRev>> resolveMessagesConflicts(int? limit) async {
		return await CardinalSdkPlatformInterface.instance.system.resolveMessagesConflicts(
			_sdkId,
			limit,
		);
	}

	Future<List<IdWithRev>> resolveDocumentsConflicts(String? ids, int? limit) async {
		return await CardinalSdkPlatformInterface.instance.system.resolveDocumentsConflicts(
			_sdkId,
			ids,
			limit,
		);
	}

	Future<IndexingInfo> getIndexingInfoByGroup(String groupId) async {
		return await CardinalSdkPlatformInterface.instance.system.getIndexingInfoByGroup(
			_sdkId,
			groupId,
		);
	}

	Future<ReplicatorDocument> getReplicatorInfo(String id) async {
		return await CardinalSdkPlatformInterface.instance.system.getReplicatorInfo(
			_sdkId,
			id,
		);
	}

	Future<String> evictAllFromMap(String mapName) async {
		return await CardinalSdkPlatformInterface.instance.system.evictAllFromMap(
			_sdkId,
			mapName,
		);
	}
}